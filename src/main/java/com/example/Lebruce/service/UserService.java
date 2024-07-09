package com.example.Lebruce.service;

import com.example.Lebruce.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface UserService {

    List<User> findAllUser();

    Optional<User> getById(Long id);

    User saveUser(User user);

    void deleteById(Long id);

}
