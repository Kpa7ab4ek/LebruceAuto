package com.example.Lebruce.service;

import com.example.Lebruce.model.Country;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CountryService {

    List<Country> findAllCountry();

    Country saveCountry(Country country);

    Optional<Country> findByCountryId(Long id);

    void deleteById(Long id);

}
