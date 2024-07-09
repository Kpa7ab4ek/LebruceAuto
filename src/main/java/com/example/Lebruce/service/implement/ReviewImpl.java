package com.example.Lebruce.service.implement;

import com.example.Lebruce.model.Review;
import com.example.Lebruce.repository.ReviewRepository;
import com.example.Lebruce.service.ReviewService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewImpl implements ReviewService {

    private final ReviewRepository repository;

    @Override
    public List<Review> findAllReview() {
        return repository.findAll();
    }

    @Override
    public Optional<Review> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Review saveReview(Review review) {
        return repository.save(review);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
