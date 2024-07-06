package com.example.Lebruce.controller;

import com.example.Lebruce.model.Brand;
import com.example.Lebruce.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/brands")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService service;

    @GetMapping()
    public ResponseEntity<?> findAllBrand() {
        return ResponseEntity.ok(service.findAllBrand());
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Brand brand) {
        return ResponseEntity.ok(service.saveBrand(brand));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Бренд успешно удален");
    }


}
