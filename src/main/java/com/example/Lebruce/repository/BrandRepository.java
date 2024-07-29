package com.example.Lebruce.repository;

import com.example.Lebruce.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand,Long> {

    List<Brand> findByName(String name);

}
