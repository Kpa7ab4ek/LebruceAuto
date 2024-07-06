package com.example.Lebruce.service;

import com.example.Lebruce.model.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandService {

    List<Brand> findAllBrand();

    Optional<Brand> getById(Long id);

    Brand saveBrand(Brand brand);

    void deleteById(Long id);

}
