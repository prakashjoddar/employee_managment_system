package com.pro.employee_managment_system.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.pro.employee_managment_system.entity.Employee;
import com.pro.employee_managment_system.repository.EmployeeRepository;

@Service
public class EmployeeService {
    EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public EmployeeRepository getRepository() {
        return repository;
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return repository.findById(id).get();
    }

    public Employee saveOrUpdateEmployee(Employee employee) {
        return repository.save(employee);
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }

    public ArrayList<Employee> findEmployeesByName(String name) {
        return repository.findEmployeesByName(name);
    }
}
