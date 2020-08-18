package com.example.AdminProject;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService
{
   // private Logger logger = (Logger) LoggerFactory.getLogger(AdminProjectApplication.class);

    private ModelMapper modelMapper;
    private AdminRepo repo;
    private EmployeeDTO employeeDTO;
    private EmployeeDAO employeeDAO;

    public AdminService(ModelMapper modelMapper, AdminRepo repo) {
        this.modelMapper = modelMapper;
        this.repo = repo;
        this.employeeDTO = new EmployeeDTO();
        this.employeeDAO = new EmployeeDAO();
    }

    //addEmployees
    public EmployeeDAO addEmployee(EmployeeDTO employeeDTO)
    {
        EmployeeEntity employee = modelMapper.map(employeeDTO,
                EmployeeEntity.class);
        repo.save(employee);

        Optional<EmployeeEntity> foundEmployee = repo.findById(employee.getId());
        if(foundEmployee.isPresent())
        {
            EmployeeEntity newEmployee = foundEmployee.get();
            employeeDAO.setId(newEmployee.getId());
            employeeDAO.setStatus("Employee Created");

        }
        return employeeDAO;
    }

    //findAllEmployees
    public List<EmployeeEntity> allEmployees()
    {
      return repo.findAll();
    }

    //deleteEmployee
    public String deleteEmployee(Long id)
    {
        Optional<EmployeeEntity> employee = repo.findById(id);
        EmployeeEntity employee1 = employee.get();
        if(employee.isPresent()) {
            repo.delete(employee1);
        }
        return (employee.isPresent())?"Employee Deleted": "Employee Not Found";


    }

    //findById
    public EmployeeEntity findEmployeedById(Long id)
    {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Id Not Found"));

    }

    //UpdateEmployee
    public Object updateEmployee(EmployeeEntity newInfo, Long id)

    {
        Optional<EmployeeEntity> emp = repo.findById(id);
        EmployeeEntity oldInfo = emp.get();
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
