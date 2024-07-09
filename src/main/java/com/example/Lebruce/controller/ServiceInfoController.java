package com.example.Lebruce.controller;


import com.example.Lebruce.model.ServiceInfo;
import com.example.Lebruce.service.ServiceInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/serviceInfo")
@RequiredArgsConstructor
public class ServiceInfoController {

    private final ServiceInfoService service;

    @GetMapping()
    public ResponseEntity<?> findAll(){
    return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody ServiceInfo serviceInfo){
        return ResponseEntity.ok(service.save(serviceInfo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok("Штука удалена");
    }

}
