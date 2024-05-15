package com.example.project.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.project.entity.Project;

@Service
public class ProjectServiceImpl implements ProjectService {

	private static final Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);

	private List<Project> projectList;

	public ProjectServiceImpl() {
		this.projectList = new ArrayList<>();
	}

	@Override
	@KafkaListener(topics = "project_topic", groupId = "projectGroup")
	public Project addProject(Project project) {
		logger.info("Project has been added to the list");
		this.projectList.add(new Project(project.getId(), project.getName(), project.getTechStack()));
		return project;
	}

	@Override
	public List<Project> getProjects() {
		return this.projectList;
	}

	@Override
	public Project getProject(int id) {
		return this.projectList.stream().filter((project) -> project.getId()==id).findFirst().orElse(null);
	}

}
