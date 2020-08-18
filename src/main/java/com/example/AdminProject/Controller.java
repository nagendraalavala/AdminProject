package com.example.AdminProject;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@EnableScheduling
@Slf4j
@RequestMapping("/api/v1/admin")
public class Controller
{
    @Autowired
    private AdminService service;
    private EmployeeDTO employeeDTO;
    private EmployeeDAO employeeDAO;
    private EmployeeEntity employeeEntity;

    private static Logger logger = LoggerFactory.getLogger(Controller.class);


//    @GetMapping("/value")
//    public String fuelType( @Value("${engine.fuelType}")String fuel)
//    {
//        return  fuel;
//    }
//
//    @GetMapping("/profile")
//    @Profile(value = "dev")
//    public String name()
//    {
//        return "This is Dev";
//    }
//
//    @GetMapping("/profile1")
//    @Profile("prod")
//    public String Pname()
//    {
//        return "This is prod Profile";
//    }
//
//    @GetMapping("/time")
//    @Scheduled(fixedRate = 10000)
//    @Scheduled(cron = "0 * * * * FRI")
//    public String ab()
//    {
//        LocalTime time = LocalTime.now();
//        String now = "Present Time " + time;
//        System.out.println(now);
//        return now;
//    }
//
//
//
//    @GetMapping("/logs")
//    public String logs()
//    {
//        log.trace("A TRACE Message");
//        log.debug("A DEBUG Message");
//        log.info("An INFO Message");
//        log.warn("A WARN Message");
//        log.error("An ERROR Message");
//
//        return "Howdy! Check out the Logs to see the output...";
//
//    }
//    @GetMapping("/servlet")
//    public void Service(HttpServletRequest request, HttpServletResponse response)
//    {
//        request.
//    }


    @PostMapping("/add")
    public EmployeeDAO addEmp(@Valid @RequestBody EmployeeDTO employee)
    {
        logger.info("Adding new Employee to DB");
        logger.trace("Tracing Logs");
        employeeDAO = service.addEmployee(employee);
        logger.info("Successfully added Employee to DB");
        return employeeDAO;

    }

    @GetMapping("/")
    public List<EmployeeEntity> allEmp() {  return service.allEmployees();  }

    @GetMapping("/{id}")
    public EmployeeEntity findEmployee(@PathVariable Long id)
    {
        return service.findEmployeedById(id);
    }

    @PutMapping("/update/{id}")
    public EmployeeEntity updateEmployee(@RequestBody @Valid EmployeeEntity employee,
                                         @PathVariable Long id)
    {
        return (EmployeeEntity) service.updateEmployee(employee,id);
    }

    @DeleteMapping("/delete/{id}")
    public Object deleteEmp(@PathVariable Long id)
    {
        return service.deleteEmployee(id);
    }

}
