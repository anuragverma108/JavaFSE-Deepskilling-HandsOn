package com.example.ormemo.entity;


import jakarta.persistence.*;
import java.util.*;

@Entity
public class Project {
    public Project(Long id, String title, List<Employee> employees) {
		super();
		this.id = id;
		this.title = title;
		this.employees = employees;
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToMany(mappedBy = "projects")
    private List<Employee> employees = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

    // Constructors, Getters, Setters
}
