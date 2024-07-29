package com.example.Lebruce.service;

import com.example.Lebruce.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> findAll();

    Optional<Order> findById(Long id);

    Order save(Order order);

    void deleteById(Long id);

    List<Order> findOrdersByEmail(String email);


}
