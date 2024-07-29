package com.example.Lebruce.service;

import com.example.Lebruce.model.Brand;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BrandService {

    List<Brand> findAllBrand();

    Optional<Brand> getById(Long id);

    Brand saveBrand(Brand brand);

    void deleteById(Long id);
    List<Brand> findByName(String name);
}
