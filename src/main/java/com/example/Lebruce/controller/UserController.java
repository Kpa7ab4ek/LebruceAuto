package com.example.Lebruce.controller;


import com.example.Lebruce.model.User;
import com.example.Lebruce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping()
    private ResponseEntity<?> findAllOrder() {
        return ResponseEntity.ok(service.findAllUser());
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }


    @PostMapping()
    private ResponseEntity<?> create(@RequestBody User user) {
        return ResponseEntity.ok(service.saveUser(user));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Пользователь удалён");
    }


}
