package com.walid.boussou.web;

import com.walid.boussou.entities.Employee;
import com.walid.boussou.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmployeeRestController {

    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public  Employee saveEmployee(@RequestBody Employee employee){
       return employeeService.saveEmployee(employee);
    }

    @PostMapping("/employees/random")
    public  Employee addRandomEmployee(){
        return employeeService.addRandomEmployee();
    }


}
