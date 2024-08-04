package com.example.Lebruce.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
@SequenceGenerator(name = "car_seq", sequenceName = "car_seq", allocationSize = 1)
public class Car {

    @Id
    @GeneratedValue
    private Long carId;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    @Min(1900)
    @Max(2024)
    private int year;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @ElementCollection
    @Size(min = 1, max = 3)
    @UniqueElements
    private List<String> imageUrls;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Service> services;

    @Override
    public String toString() {
        return (brand != null ? brand.getName() : null) + " " + model + ", год выпуска:" + year;
    }
}