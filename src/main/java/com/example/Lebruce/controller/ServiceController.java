package com.example.Lebruce.controller;

import com.example.Lebruce.model.Service;
import com.example.Lebruce.service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/services")
@RequiredArgsConstructor
public class ServiceController {
    private final ServiceService serviceService;

    @GetMapping()
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(serviceService.findAllService());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(serviceService.findServiceById(id));
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Service service){
        return ResponseEntity.ok( serviceService.createService(service));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        serviceService.deleteServiceById(id);
        return ResponseEntity.ok("Услуга c id: " + id + " удалена");
    }
}
