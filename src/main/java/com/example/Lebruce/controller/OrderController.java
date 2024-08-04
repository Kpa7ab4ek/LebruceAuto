package com.example.Lebruce.controller;

import com.example.Lebruce.model.Car;
import com.example.Lebruce.model.DTO.OrderDTO;
import com.example.Lebruce.model.Order;
import com.example.Lebruce.model.Service;
import com.example.Lebruce.service.EmailService;
import com.example.Lebruce.service.OrderService;
import com.example.Lebruce.service.implement.EmailImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("api/v1/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService service;

    private final EmailService emailService;

    @GetMapping()
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("email")
    public List<Order> findOrdersByEmail(@RequestParam String email) {
        return service.findOrdersByEmail(email);
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody Order order) {
        return ResponseEntity.ok(service.save(order));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Zаказ успешно удален");
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Map<String, Object> updatedFields) {
        ObjectMapper objectMapper = new ObjectMapper();

        return service.findById(id)
                .map(order -> {
                    updatedFields.forEach((key, value) -> {
                        switch (key) {
                            case "firstName":
                                order.setFirstName((String) value);
                                break;
                            case "secondName":
                                order.setSecondName((String) value);
                                break;
                            case "thirdName":
                                order.setThirdName((String) value);
                                break;
                            case "car":
                                if (value instanceof Map) {
                                    Car car = objectMapper.convertValue(value, Car.class);
                                    order.setCar(car);
                                } else {
                                    throw new RuntimeException("Invalid car format: " + value);
                                }
                                break;
                            case "selectedServices":
                                if (value instanceof List) {
                                    List<Service> services = objectMapper.convertValue(value, new TypeReference<List<Service>>() {});
                                    order.setSelectedServices(services);
                                } else {
                                    throw new RuntimeException("Invalid selectedServices format: " + value);
                                }
                                break;
                            case "numberPhone":
                                order.setNumberPhone((String) value);
                                break;
                            case "email":
                                order.setEmail((String) value);
                                break;
                            case "date":
                                if (value instanceof String) {
                                    LocalDate date = LocalDate.parse((String) value, DateTimeFormatter.ISO_LOCAL_DATE);
                                    order.setDate(date);
                                } else {
                                    throw new RuntimeException("Invalid date format: " + value);
                                }
                                break;
                            case "status":
                                order.setStatus((String) value);
                                break;
                            default:
                                throw new RuntimeException("Invalid field name: " + key);
                        }
                    });
                    return service.save(order);
                })
                .orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    }

    @PutMapping("/update/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody OrderDTO updatedFields) {
        return service.findById(id)
                .map(order -> {
                    if (updatedFields.getFirstName() != null) {
                        order.setFirstName(updatedFields.getFirstName());
                    }
                    if (updatedFields.getSecondName() != null) {
                        order.setSecondName(updatedFields.getSecondName());
                    }
                    if (updatedFields.getThirdName() != null) {
                        order.setThirdName(updatedFields.getThirdName());
                    }
                    if (updatedFields.getCar() != null) {
                        order.setCar(updatedFields.getCar());
                    }
                    if (updatedFields.getSelectedServices() != null) {
                        order.setSelectedServices(updatedFields.getSelectedServices());
                    }
                    if (updatedFields.getNumberPhone() != null) {
                        order.setNumberPhone(updatedFields.getNumberPhone());
                    }
                    if (updatedFields.getEmail() != null) {
                        order.setEmail(updatedFields.getEmail());
                    }
                    if (updatedFields.getDate() != null) {
                        LocalDate date = LocalDate.parse(updatedFields.getDate(), DateTimeFormatter.ISO_LOCAL_DATE);
                        order.setDate(date);
                    }
                    if (updatedFields.getStatus() != null) {
                        order.setStatus(updatedFields.getStatus());
                    }
                    return service.save(order);
                })
                .orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    }
}
