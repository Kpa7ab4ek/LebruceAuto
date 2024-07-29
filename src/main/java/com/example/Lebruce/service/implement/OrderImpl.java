package com.example.Lebruce.service.implement;

import com.example.Lebruce.model.Order;
import com.example.Lebruce.repository.OrderRepository;
import com.example.Lebruce.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderImpl implements OrderService {

    private final OrderRepository repository;

    @Override
    public List<Order> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Order save(Order order) {
        return repository.save(order);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Order> findOrdersByEmail(String email) {
        return repository.findByEmail(email);
    }
}
