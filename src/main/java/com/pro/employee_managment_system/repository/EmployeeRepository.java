package com.pro.employee_managment_system.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.pro.employee_managment_system.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "select * from employee where first_name like %?%", nativeQuery = true)
    public ArrayList<Employee> findEmployeesByName(String name);

}
