package com.example.AdminProject;

import lombok.Data;

@Data
public class EmployeeDTO
{

    private String empUsername;
    private String empPassword;
    private String empDepartment;
    private String empName;
    private String empEmail;
    private Long empPhoneNumber;
    private String status;
}
