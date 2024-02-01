package com.employeemanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagement.model.Employee;
import com.employeemanagement.serviceIMPL.EmployeeServiceImpl;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl empService;
	
	@GetMapping("/home")
	public String homePage() {
		return "Welcome to Employee Management";
	}
	
	@PostMapping("/addEmp")
	public ResponseEntity<Employee> addEmployee (@RequestBody Employee employee) {
		Employee emp = empService.addEmployee(employee);
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/removeEmp/{id}")
	public ResponseEntity<String> removeEmployee (@PathVariable int id) {
		empService.removeEmployee(id);
		return new ResponseEntity<String>("Remove Successfully", HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/findEmp/{id}")
	public ResponseEntity<Optional<Employee>> findEmployeeById (@PathVariable int id) {
		Optional<Employee> emps = empService.findEmployeeById(id);
		
		return new ResponseEntity<Optional<Employee>>(emps, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/findAllEmp/{id}")
	public ResponseEntity<List<Employee>> getAllEmployees (@PathVariable int id) {
		List<Employee> lEmp = empService.getAllEmployee();
		return new ResponseEntity<List<Employee>>(lEmp, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/updateEmp/{id}")
	public ResponseEntity<String> updateEmployee (@PathVariable int id) {
		String uEmp = empService.updateEmployee(id);
		return new ResponseEntity<String>(uEmp, HttpStatus.ACCEPTED);
	}
}
