package com.example.Lebruce.service.implement;

import com.example.Lebruce.model.Brand;
import com.example.Lebruce.repository.BrandRepository;
import com.example.Lebruce.service.BrandService;
import com.example.Lebruce.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BrandImpl implements BrandService {
    private final BrandRepository repository;

    @Override
    public List<Brand> findAllBrand() {
     return repository.findAll();
    }

    @Override
    public Optional<Brand> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Brand saveBrand(Brand brand) {
       return repository.save(brand);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
