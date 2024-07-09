package com.example.Lebruce.controller;

import com.example.Lebruce.model.Review;
import com.example.Lebruce.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService service;


    @GetMapping()
    private ResponseEntity<?> findAllOrder(){
        return ResponseEntity.ok(service.findAllReview());
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping()
    private ResponseEntity<?> create(@RequestBody Review review){
        return ResponseEntity.ok(service.saveReview(review));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok("Заказ удалён");
    }
}
