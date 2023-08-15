package com.example.employee.service;

import java.util.List;

import com.example.employee.entity.Employee;

public interface EmployeeService {
	List<Employee> getEmployees();
	Employee getEmployee(int id);
	Employee addEmployee(Employee employee);
}
