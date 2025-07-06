package com.example.demo.loader;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) {
        employeeRepository.save(new Employee(null, "Alice", "alice@company.com", 80000.0, "HR", LocalDate.of(2023, 1, 15)));
        employeeRepository.save(new Employee(null, "Bob", "bob@company.com", 95000.0, "IT", LocalDate.of(2022, 3, 10)));
        employeeRepository.save(new Employee(null, "Charlie", "charlie@company.com", 50000.0, "Finance", LocalDate.of(2023, 5, 20)));
        employeeRepository.save(new Employee(null, "David", "david@company.com", 120000.0, "IT", LocalDate.of(2021, 6, 18)));
        employeeRepository.save(new Employee(null, "Eve", "eve@company.com", 75000.0, "HR", LocalDate.of(2024, 2, 1)));
    }
}
