package com.example.Lebruce.model.DTO;

import com.example.Lebruce.model.Car;
import com.example.Lebruce.model.Service;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private String firstName;
    private String secondName;
    private String thirdName;
    private Car car;
    private List<Service> selectedServices;
    private String numberPhone;
    private String email;
    private String date;
    private String status;

}
