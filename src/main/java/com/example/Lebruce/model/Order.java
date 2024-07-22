package com.example.Lebruce.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String secondName;

    @Column(nullable = false)
    private String thirdName;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @ManyToMany
    @JoinTable(
            name = "order_service",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id"))
    private List<Service> selectedServices;


    @Pattern(regexp = "^[0-9]{11}$")
    private String numberPhone;

    private String email;

    private LocalDate date;


    //Сделать как-то подсчёт суммы
    private Double totalPrice;
}
