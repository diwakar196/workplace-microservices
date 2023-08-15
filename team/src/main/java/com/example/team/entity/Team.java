package com.example.team.entity;

import com.example.team.entity.Team;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {
	private int id;
	private String name;
}