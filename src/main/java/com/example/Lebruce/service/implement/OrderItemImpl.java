package com.example.Lebruce.service.implement;


import com.example.Lebruce.model.OrderItem;
import com.example.Lebruce.repository.OrderItemRepository;
import com.example.Lebruce.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderItemImpl implements OrderItemService {

    private final OrderItemRepository repository;

    @Override
    public List<OrderItem> findAllOrderItem() {
        return repository.findAll();
    }

    @Override
    public Optional<OrderItem> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public OrderItem saveOrderItem(OrderItem orderItem) {
        return repository.save(orderItem);
    }

    @Override
    public void deleteById(Long id) {
            repository.deleteById(id);
    }
}
