package com.example.Lebruce.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Car {

    private long id;

    private String name;

    private LocalDate date;

    private String transmission;

    private String typeWeight;

    private String typeBody;


}
