package com.example.Lebruce.service;

import com.example.Lebruce.model.Service;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public interface ServiceService {

    List<Service> findAllService();

    Service createService(Service service);

    Optional<Service> findServiceById(Long id);

    void deleteServiceById(Long id);

}
