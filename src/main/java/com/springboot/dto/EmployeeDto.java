package com.springboot.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class EmployeeDto {

    private int id;

    @NotEmpty(message = "Employee first name cannot be null or empty")
    private String firstname;

    @NotEmpty(message = "Employee last name cannot be null or empty")
    private String lastname;

    @NotEmpty(message = "Employee city cannot be null or empty")
    private String city;

    @Min(value = 1, message = "Employee Department id cannot be null or empty")
    private int department_id;

}
