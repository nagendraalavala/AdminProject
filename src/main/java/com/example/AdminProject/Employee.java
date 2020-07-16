package com.example.AdminProject;


import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@Data
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @NotBlank(message = "Username Should not be Null")
    private String empUsername;
    @NotBlank(message = "Password Should not be Null")
    private String empPassword;
    @NotBlank(message = "Department Should not be Null")
    private String empDepartment;
    @NotBlank(message = "Name Should not be Null")
    private String empName;
    @Email(message = "Email Should not be Null")
    private String empEmail;
    @NotNull(message = "Please Enter Numbers")
    private Long empPhoneNumber;


}
