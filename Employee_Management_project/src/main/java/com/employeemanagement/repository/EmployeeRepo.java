package com.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeemanagement.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
