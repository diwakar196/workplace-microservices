package com.example.employee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.entity.Employee;
import com.example.employee.service.EmployeeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/all")
	public List<Employee> getEmployees() {
		return this.employeeService.getEmployees();
	}
	
	@GetMapping("/{userId}")
	public Employee getEmployee(@PathVariable String userId) {
		return this.employeeService.getEmployee(Integer.parseInt(userId));
	}
	
	@PostMapping("/add")
	@CircuitBreaker(name = "employeeCircuitBreaker", fallbackMethod = "employeeFallBack")
	public Employee addEmployee(@RequestBody Employee employee) {
		return this.employeeService.addEmployee(employee);
	}
	
	public Employee employeeFallBack(Employee employee, Exception ex) {
		logger.error("One of the Microservice is down, executing fallback Method");
		return new Employee(employee.getId(),"Dummy","Employee",employee.getTeam(),employee.getProjects());
	}
}
