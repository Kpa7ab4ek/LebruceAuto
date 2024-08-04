package com.example.Lebruce.service.implement;

import com.example.Lebruce.model.Car;
import com.example.Lebruce.model.DTO.EmailContext;
import com.example.Lebruce.model.Order;
import com.example.Lebruce.repository.CarRepository;
import com.example.Lebruce.repository.OrderRepository;
import com.example.Lebruce.repository.ServiceRepository;
import com.example.Lebruce.service.EmailService;
import com.example.Lebruce.service.OrderService;
import jakarta.mail.MessagingException;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderImpl implements OrderService {

    private final OrderRepository repository;

    private final EmailService emailService;

    private final CarRepository carRepository;

    private final ServiceRepository serviceRepository;

    @Override
    public List<Order> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Order save(Order request) {
        // Загружаем связанные объекты
        Car car = carRepository.findById(request.getCar().getCarId()).orElseThrow(() -> new RuntimeException("Car not found"));
        List<com.example.Lebruce.model.Service> services = request.getSelectedServices().stream()
                .map(selectedService -> serviceRepository.findById(selectedService.getServiceId())
                        .orElseThrow(() -> new RuntimeException("Service not found")))
                .collect(Collectors.toList()).reversed();

        // Заполняем связанные объекты в заказе
        request.setCar(car);
        request.setSelectedServices(services);

        // Сохраняем заказ
        Order savedOrder = repository.save(request);

        // Создаем контекст для email
        EmailContext emailContext = EmailContext.builder()
                .from("ivanov13032004@mail.ru")
                .to(savedOrder.getEmail()) // Предполагается, что у заказа есть поле с email клиента
                .subject("Информация о заказе")
                .templateLocation("message") // Путь к шаблону email
                .context(Map.of(
                        "orderId", savedOrder.getId(),
                        "firstName", savedOrder.getFirstName(),
                        "secondName", savedOrder.getSecondName(),
                        "thirdName", savedOrder.getThirdName(),
                        "orderDate", savedOrder.getDate(),
                        "totalPrice", savedOrder.getTotalPrice(),
                        "car", savedOrder.getCar(),
                        "selectedServices", savedOrder.getSelectedServices()
                ))
                .build();

        // Отправляем email
        try {
            emailService.sendEmail(emailContext);
        } catch (MessagingException e) {
            e.printStackTrace();
            return null;
        }

        return savedOrder;
    }



    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Order> findOrdersByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Order updateOrder(Long id, Order orderDetails) {
        Optional<Order> orderOptional = repository.findById(id);

        if (orderOptional.isPresent()) {
            Order existingOrder = orderOptional.get();

            ModelMapper modelMapper = new ModelMapper();
            modelMapper.map(orderDetails, existingOrder);

            return repository.save(existingOrder);
        } else {
            throw new EntityNotFoundException("Order not found with id " + id);
        }
    }

}
