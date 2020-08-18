package com.example.AdminProject;


import lombok.Data;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.Auditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import sun.rmi.runtime.Log;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
public class EmployeeEntity
{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @NotBlank(message = "Username Should not be Null")
    private String empUsername;
    @NotBlank(message = "Password Should not be Null")
    @Transient
    private String empPassword;
    @NotBlank(message = "Department Should not be Null")
    private String empDepartment;
    @NotBlank(message = "Name Should not be Null")
    private String empName;
    @Email(message = "Email Should not be Null")
    private String empEmail;
    @NotNull(message = "Please Enter only Numbers")
    private Long empPhoneNumber;
    private String status;
    private String contractStatus;



}
