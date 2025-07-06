package com.example.ormemo.loader;

import com.example.ormemo.entity.*;
import com.example.ormemo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataLoader implements CommandLineRunner {

    private final DepartmentRepository deptRepo;
    private final EmployeeRepository empRepo;
    private final ProjectRepository projectRepo;

    public DataLoader(DepartmentRepository d, EmployeeRepository e, ProjectRepository p) {
        this.deptRepo = d;
        this.empRepo = e;
        this.projectRepo = p;
    }

    @Override
    public void run(String... args) {
        Department hr = deptRepo.save(new Department(null, "HR", new ArrayList<>()));
        Department it = deptRepo.save(new Department(null, "IT", new ArrayList<>()));

        Project p1 = projectRepo.save(new Project(null, "Apollo", new ArrayList<>()));
        Project p2 = projectRepo.save(new Project(null, "Artemis", new ArrayList<>()));

        Employee e1 = new Employee(null, "Alice", hr, new ArrayList<>());
        Employee e2 = new Employee(null, "Bob", it, new ArrayList<>());

        e1.getProjects().add(p1);
        e2.getProjects().addAll(List.of(p1, p2));

        empRepo.saveAll(List.of(e1, e2));
    }
}
