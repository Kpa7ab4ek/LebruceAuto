package com.example.Lebruce.controller;

import com.example.Lebruce.model.Car;
import com.example.Lebruce.service.CarService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService service;

    @GetMapping()
    public ResponseEntity<?> findCar() {
        return ResponseEntity.ok(service.findAllCar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findCarById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping()
    public ResponseEntity<?> createCar(@RequestBody Car car){
        return  ResponseEntity.ok(service.saveCar(car));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCasById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok("Машина удалена");
    }

}
