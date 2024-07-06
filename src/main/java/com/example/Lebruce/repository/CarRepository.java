package com.example.Lebruce.repository;

import com.example.Lebruce.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {


}
