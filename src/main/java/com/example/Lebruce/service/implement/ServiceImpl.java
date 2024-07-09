package com.example.Lebruce.service.implement;

import com.example.Lebruce.model.Service;
import com.example.Lebruce.repository.ServiceRepository;
import com.example.Lebruce.service.ServiceService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceImpl implements ServiceService {

    private final ServiceRepository repository;

    @Override
    public List<Service> findAllService() {
        return repository.findAll();
    }

    @Override
    public Service createService(Service service) {
            return repository.save(service);
    }

    @Override
    public Optional<Service> findServiceById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteServiceById(Long id) {
        repository.deleteById(id);
    }
}
