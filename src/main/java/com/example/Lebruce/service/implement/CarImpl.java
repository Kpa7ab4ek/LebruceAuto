package com.example.Lebruce.service.implement;

import com.example.Lebruce.model.Car;
import com.example.Lebruce.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarImpl implements CarService {
    @Override
    public List<Car> findAllCar() {
        return null;
    }

    @Override
    public Car saveCar(Car car) {
        return null;
    }

    @Override
    public Car findById(long id) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }
}
