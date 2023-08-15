package com.example.project.service;

import java.util.List;

import com.example.project.entity.Project;

public interface ProjectService {
	Project addProject(Project project);
	List<Project> getProjects();
	Project getProject(int id);
}
