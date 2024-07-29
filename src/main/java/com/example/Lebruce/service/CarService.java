package com.example.Lebruce.service;


import com.example.Lebruce.model.Car;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public interface CarService {

    List<Car> findAllCar();

    Car saveCar(Car car);

    Optional<Car> findById(Long id);

    void deleteById(Long id);

    List<Car> findByModel(String model);

    List<Car> findAllByBrand_Name(String name);

    List<Car> findAllByCountryName(@Param("countryName") String countryName);

}
