package com.example.Lebruce.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "services")
@SequenceGenerator(name = "service_seq", sequenceName = "service_seq", allocationSize = 1)
public class Service {

    @Id
    @GeneratedValue
    private Long serviceId;

    @Column(nullable = false)
    private String serviceName;

    @Column(nullable = false)
    private double servicePrice;

    @Column(length = 1000)
    private String serviceDescription;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    @JsonBackReference
    private Car car;

}
