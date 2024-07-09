package com.example.Lebruce.service;

import com.example.Lebruce.model.OrderItem;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderItemService {

    List<OrderItem> findAllOrderItem();

    Optional<OrderItem> getById(Long id);

    OrderItem saveOrderItem(OrderItem orderItem);

    void deleteById(Long id);

}
