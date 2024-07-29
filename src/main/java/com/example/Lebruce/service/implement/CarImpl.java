package com.example.Lebruce.service.implement;

import com.example.Lebruce.model.Car;
import com.example.Lebruce.repository.CarRepository;
import com.example.Lebruce.service.CarService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.stream.Collectors;

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

    @Override
    public List<Car> findByModel(String model) {
        return repository.findByModel(model);
    }

    @Override
    public List<Car> findAllByBrand_Name(String name) {
        return repository.findAllByBrand_Name(name);
    }

    @Override
    public List<Car> findAllByCountryName(String countryName) {
        return repository.findAllByCountryName(countryName);
    }

}
