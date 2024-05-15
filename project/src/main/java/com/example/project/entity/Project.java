package com.example.project.entity;


import com.example.project.entity.Project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
	private int id;
	private String name;
	private String techStack;
}
