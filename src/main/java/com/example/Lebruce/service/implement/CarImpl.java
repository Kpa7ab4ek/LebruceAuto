package com.example.Lebruce.service.implement;

import com.example.Lebruce.model.Car;
import com.example.Lebruce.repository.CarRepository;
import com.example.Lebruce.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarImpl implements CarService {

    private final CarRepository repository;

    @Override
    public List<Car> findAllCar() {
        return repository.findAll();
    }

    @Override
    public Car saveCar(Car car) {
        return repository.save(car);
    }

    @Override
    public Optional<Car> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
