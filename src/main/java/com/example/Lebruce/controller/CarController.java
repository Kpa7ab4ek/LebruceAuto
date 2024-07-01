package com.example.Lebruce.controller;

import com.example.Lebruce.service.CarService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService service;

    @GetMapping()
    public ResponseEntity<?> findAllCar() {
        return ResponseEntity.ok(service.findAllCar());
    }

}
