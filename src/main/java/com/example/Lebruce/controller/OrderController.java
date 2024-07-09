package com.example.Lebruce.controller;

import com.example.Lebruce.model.Order;
import com.example.Lebruce.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor

public class OrderController {

    private final OrderService service;

    @GetMapping()
    private ResponseEntity<?> findAllOrder(){
        return ResponseEntity.ok(service.findAllOrder());
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping()
    private ResponseEntity<?> create(@RequestBody Order order){
        return ResponseEntity.ok(service.saveOrder(order));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok("Заказ удалён");
    }
}
