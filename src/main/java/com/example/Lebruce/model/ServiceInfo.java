package com.example.Lebruce.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@SequenceGenerator(name = "service_info_seq", sequenceName = "service_info_seq", allocationSize = 1)
public class ServiceInfo {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String info;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    @JsonIgnore
    private Service service;
}
