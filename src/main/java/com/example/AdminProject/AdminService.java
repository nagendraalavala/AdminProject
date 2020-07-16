package com.example.AdminProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService
{
    @Autowired
    private AdminRepo repo;

    //addEmployees
    public Employee addEmployee(Employee employee)
    {
        return repo.save(employee);
    }

    //findAllEmployees
    public List<Employee> allEmployees()
    {
      return repo.findAll();
    }

    //deleteEmployee
    public String deleteEmployee(Long id)
    {
        Optional<Employee> employee = repo.findById(id);
        Employee employee1 = employee.get();
        if(employee.isPresent())
        {
            repo.delete(employee1);
            return "User Deleted";

        }
        else
        {
            return "Id Not Found";
        }

    }

    //findById
    public Optional<Employee> findEmployeedById(Long id)
    {
        return repo.findById(id);

    }

    //UpdateEmployee
    public Object updateEmployee(Employee newInfo, Long id)

    {
        Optional<Employee> emp = repo.findById(id);
        Employee oldInfo = emp.get();
        if (emp.isPresent())
        {
            oldInfo.setEmpUsername(newInfo.getEmpUsername());
            oldInfo.setEmpDepartment(newInfo.getEmpDepartment());
            oldInfo.setEmpEmail(newInfo.getEmpEmail());
            oldInfo.setEmpName(newInfo.getEmpName());
            oldInfo.setEmpPassword(newInfo.getEmpPassword());
            oldInfo.setEmpPhoneNumber(newInfo.getEmpPhoneNumber());
            return  repo.save(oldInfo);
        }
        else
        {
            return"Wrong Id";
        }


    }

}
