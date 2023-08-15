package com.example.team.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.team.entity.Team;
import com.example.team.service.TeamService;

@RestController
@RequestMapping("/team")
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	@GetMapping("/all")
	public List<Team> getTeams() {
		return this.teamService.getTeams();
	}
	
	@GetMapping("/{teamId}")
	public Team getTeam(@PathVariable String teamId) {
		return this.teamService.getTeam(Integer.parseInt(teamId));
	}
}
