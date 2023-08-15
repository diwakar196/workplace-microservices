package com.example.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.example.employee.entity.Employee;
import com.example.employee.entity.Project;
import com.example.employee.entity.Team;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private List<Employee> employeeList;
	
	@Autowired
	private KafkaTemplate<String, Project> projectKafkaTemplate;
	
	@Autowired
	private KafkaTemplate<String, Team> teamKafkaTemplate;

	public EmployeeServiceImpl() {
		employeeList = new ArrayList<>();
	}

	@Override
	public List<Employee> getEmployees() {
		return this.employeeList;
	}

	@Override
	public Employee getEmployee(int id) {
		return this.employeeList.stream().filter((employee) -> employee.getId() == id).findFirst().orElse(null);
	}

	@Override
	public Employee addEmployee(Employee employee) {
		this.employeeList.add(new Employee(employee.getId(), employee.getFirstName(), employee.getLastName(),
				employee.getTeam(), employee.getProjects()));
		List<Project> projects = employee.getProjects();
		Team team = employee.getTeam();
		for(Project project : projects) {
			Message<Project> message = MessageBuilder.withPayload(project).setHeader(KafkaHeaders.TOPIC, "project_topic").build();
			this.projectKafkaTemplate.send(message);
		}
		Message<Team> message = MessageBuilder.withPayload(team).setHeader(KafkaHeaders.TOPIC, "team_topic").build();
		this.teamKafkaTemplate.send(message);
		return employee;
	}

}
