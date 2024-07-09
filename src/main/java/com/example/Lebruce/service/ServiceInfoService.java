package com.example.Lebruce.service;

import com.example.Lebruce.model.ServiceInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ServiceInfoService {

    List<ServiceInfo> findAll();

    ServiceInfo save(ServiceInfo serviceInfo);

    Optional<ServiceInfo> findById(Long id);

    void deleteById(Long id);
}
