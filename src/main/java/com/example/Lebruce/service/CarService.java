package com.example.Lebruce.service;


import com.example.Lebruce.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CarService {

    List<Car> findAllCar();

    Car saveCar(Car car);

    Optional<Car> findById(Long id);

    void deleteById(Long id);

}
