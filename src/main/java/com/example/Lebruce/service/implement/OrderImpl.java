package com.example.Lebruce.service.implement;

import com.example.Lebruce.model.Order;
import com.example.Lebruce.repository.OrderRepository;
import com.example.Lebruce.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderImpl implements OrderService {

    private final OrderRepository repository;

    @Override
    public List<Order> findAllOrder() {
        return repository.findAll();
    }

    @Override
    public Optional<Order> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Order saveOrder(Order order) {
        return repository.save(order);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
