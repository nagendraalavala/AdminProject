package com.example.AdminProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class Controller
{
    @Autowired
    private AdminService service;

    @PostMapping("/add")
    public Employee addEmp(@Valid @RequestBody Employee employee)
    {
        return service.addEmployee(employee);
    }

    @GetMapping("/")
    public List<Employee> allEmp()
    {
        return service.allEmployees();
    }

    @GetMapping("/{id}")
    public Optional<Employee> findEmployee(@PathVariable Long id)
    {
        return service.findEmployeedById(id);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@RequestBody @Valid Employee employee,
                                   @PathVariable Long id)
    {
        return (Employee) service.updateEmployee(employee,id);
    }

    @DeleteMapping("/delete/{id}")
    public Object deleteEmp(@PathVariable Long id)
    {
        return service.deleteEmployee(id);
    }

}
