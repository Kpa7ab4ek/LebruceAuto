package com.example.Lebruce.repository;

import com.example.Lebruce.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findAllByBrand_Name(String name);

    @Query("SELECT c FROM Car c WHERE LOWER(c.model) LIKE LOWER(CONCAT('%', :model, '%'))")
    List<Car> findByModel(@Param("model") String model);

    @Query("SELECT c FROM Car c JOIN c.brand b JOIN b.country country WHERE country.name = :countryName")
    List<Car> findAllByCountryName(@Param("countryName") String countryName);
}
