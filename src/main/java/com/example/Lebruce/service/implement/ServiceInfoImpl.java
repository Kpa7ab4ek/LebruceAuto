package com.example.Lebruce.service.implement;


import com.example.Lebruce.model.ServiceInfo;
import com.example.Lebruce.repository.ServiceInfoRepository;
import com.example.Lebruce.service.ServiceInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceInfoImpl implements ServiceInfoService {

    private final ServiceInfoRepository repository;

    @Override
    public List<ServiceInfo> findAll() {
        return repository.findAll();
    }

    @Override
    public ServiceInfo save(ServiceInfo serviceInfo) {
        return repository.save(serviceInfo);
    }

    @Override
    public Optional<ServiceInfo> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
