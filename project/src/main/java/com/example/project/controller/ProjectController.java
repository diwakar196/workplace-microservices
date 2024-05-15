package com.example.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.entity.Project;
import com.example.project.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired 
	private ProjectService projectService;
	
	@GetMapping("/all")
	public List<Project> getProjects() {
		return this.projectService.getProjects();
	}
	
	@GetMapping("/{projectId}")
	public Project getProject(@PathVariable String projectId) {
		return this.projectService.getProject(Integer.parseInt(projectId));
	}
}
