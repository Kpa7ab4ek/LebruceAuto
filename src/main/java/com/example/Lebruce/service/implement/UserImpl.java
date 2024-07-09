package com.example.Lebruce.service.implement;

import com.example.Lebruce.model.User;
import com.example.Lebruce.repository.UserRepository;
import com.example.Lebruce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserImpl implements UserService {

    private final UserRepository repository;

    @Override
    public List<User> findAllUser() {
        return repository.findAll();
    }

    @Override
    public Optional<User> getById(Long id) {
        return repository.findById(id);
    }




    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }


}
