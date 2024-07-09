package com.example.Lebruce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue
    private Long countryId;

    @Column(nullable = false)
    private String name;
}
