package com.example.Lebruce.service;

import com.example.Lebruce.model.Review;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface ReviewService {

    List<Review> findAllReview();

    Optional<Review> getById(Long id);

    Review saveReview(Review review);

    void deleteById(Long id);

}
