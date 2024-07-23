package com.example.Lebruce.controller;

import com.example.Lebruce.model.Car;
import com.example.Lebruce.model.Order;
import com.example.Lebruce.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;


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

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Map<String, Object> updatedFields) {
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
                                Car car = new Car();
                                car.setCarId((Long) value);
                                order.setCar(car);
                                break;
                            case "numberPhone":
                                order.setNumberPhone((String) value);
                                break;
                            case "email":
                                order.setEmail((String) value);
                                break;
                            case "date":
                                order.setDate((LocalDate) value);
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
}
