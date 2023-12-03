package com.walid.boussou.services;

import com.walid.boussou.entities.Employee;
import com.walid.boussou.repositories.EmpolyeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class EmployeeService {

    private EmpolyeeRepository empolyeeRepository;

    public List<Employee> getAllEmployees(){
        return empolyeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee){
        return empolyeeRepository.save(employee);
    }

    public Employee addRandomEmployee() {
        Employee newEmployee = new Employee();
        newEmployee.setName(generateRandomName());
        newEmployee.setPosition(generateRandomPosition());
        newEmployee.setSalary(generateRandomSalary());

        return empolyeeRepository.save(newEmployee);
    }


    private String generateRandomName() {
        String[] names = {"Walid", "Amine", "Yassine", "Hind", "Soufiane"};
        return names[new Random().nextInt(names.length)];
    }

    private String generateRandomPosition() {
        String[] positions = {"Full Stack Engineer", "Mobile Developer", "Data Analyst", "UX UI Designer"};
        return positions[new Random().nextInt(positions.length)];
    }

    private double generateRandomSalary() {
        double salary = 50000 + new Random().nextDouble() * 50000;
        return Math.round(salary * 100.0) / 100.0;
    }


}
