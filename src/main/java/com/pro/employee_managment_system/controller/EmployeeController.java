package com.pro.employee_managment_system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.employee_managment_system.entity.Employee;
import com.pro.employee_managment_system.service.EmployeeService;

import lombok.Data;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class EmployeeController {
    EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<List<Employee>>(service.getAllEmployees(), HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(service.saveOrUpdateEmployee(employee), HttpStatus.CREATED);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
        service.getRepository().findById(id)
                .orElseThrow(() -> new NoSuchElementException("Employee Id " + id + " not found"));

        service.deleteEmployee(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);

        return new ResponseEntity<Map<String, Boolean>>(response, HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeByName(@PathVariable Long id) {
        return new ResponseEntity<Employee>(service.getEmployeeById(id), HttpStatus.OK);
    }

    // @GetMapping("/employees/{name}")
    // public ResponseEntity<ArrayList<Employee>> getEmployeeByName(@PathVariable
    // String name) {
    // return new
    // ResponseEntity<ArrayList<Employee>>(service.findEmployeesByName(name),
    // HttpStatus.OK);
    // }

}
