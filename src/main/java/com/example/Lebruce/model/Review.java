package com.example.Lebruce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "reviews", indexes = {
        @Index(name = "idx_review_rating", columnList = "rating")
})
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne
    @JoinColumn(name = "service_id")
    @JsonIgnore
    private Service service;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Range(min = 1, max = 5)
    @Column(nullable = false)
    private int rating;

    @Column(length = 500)
    private String comment;

    private LocalDateTime datePosted;

    @PrePersist
    private void onCreate() {
        datePosted = LocalDateTime.now();
    }
}