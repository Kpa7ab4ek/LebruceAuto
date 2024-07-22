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
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
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
}
