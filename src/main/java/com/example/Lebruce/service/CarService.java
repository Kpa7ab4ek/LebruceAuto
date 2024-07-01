package com.example.Lebruce.service;


import com.example.Lebruce.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {

    List<Car> findAllCar();

    Car saveCar(Car car);

    Car findById(long id);

    void deleteById(long id);

}
