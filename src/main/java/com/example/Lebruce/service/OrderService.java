package com.example.Lebruce.service;

import com.example.Lebruce.model.Brand;
import com.example.Lebruce.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderService {

    List<Order> findAllOrder();

    Optional<Order> getById(Long id);

    Order saveOrder(Order order);

    void deleteById(Long id);

}
