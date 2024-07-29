package com.example.Lebruce.controller;


import com.example.Lebruce.model.Country;
import com.example.Lebruce.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/countries")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService service;

    @GetMapping()
    private ResponseEntity<?> findAllCar(){
        return ResponseEntity.ok(service.findAllCountry());
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findByCountryId(id));
    }

    @PostMapping()
    private ResponseEntity<?> create(@RequestBody Country country){
        return ResponseEntity.ok(service.saveCountry(country));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok("Страна c id: " + id + " удалена");
    }

}
