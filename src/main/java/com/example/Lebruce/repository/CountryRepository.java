package com.example.Lebruce.repository;

import com.example.Lebruce.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {
}
