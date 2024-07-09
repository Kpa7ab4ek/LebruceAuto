package com.example.Lebruce.service.implement;

import com.example.Lebruce.model.Country;
import com.example.Lebruce.repository.CountryRepository;
import com.example.Lebruce.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CountryImpl implements CountryService {
    private final CountryRepository repository;

    @Override
    public List<Country> findAllCountry() {
        return repository.findAll();
    }

    @Override
    public Country saveCountry(Country country) {
        return repository.save(country);
    }

    @Override
    public Optional<Country> findByCountryId(Long id) {
        return repository.findById(id);
    }


    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
