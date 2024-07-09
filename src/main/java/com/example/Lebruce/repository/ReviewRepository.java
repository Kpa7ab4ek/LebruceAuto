package com.example.Lebruce.repository;

import com.example.Lebruce.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
