package com.example.Lebruce.controller;

import com.example.Lebruce.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/brands")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService service;

    @GetMapping()
    public ResponseEntity<?> findAllBrand() {
        return ResponseEntity.ok(service.findAllBrand());
    }

}
