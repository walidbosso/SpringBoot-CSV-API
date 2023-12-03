package com.walid.boussou;

import com.walid.boussou.entities.Employee;
import com.walid.boussou.repositories.EmpolyeeRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
@AllArgsConstructor
public class StartupInitializer {

    private EmpolyeeRepository empolyeeRepository;

    @PostConstruct
    public void initialize() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/employees.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Employee employee = createEntityFromCsvLine(line);
                if (employee != null)
                   empolyeeRepository.save(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Employee createEntityFromCsvLine(String csvLine) {
        if (csvLine.startsWith("id,name,position,salary"))
            return null;

        String[] values = csvLine.split(",");
        if (values.length != 4)
            return null;
        Employee employee = new Employee();
        employee.setId(Long.parseLong(values[0]));
        employee.setName(values[1]);
        employee.setPosition(values[2]);
        employee.setSalary(Double.parseDouble(values[3]));
        return employee;
    }
}
