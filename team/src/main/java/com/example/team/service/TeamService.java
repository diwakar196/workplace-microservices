package com.example.team.service;

import java.util.List;

import com.example.team.entity.Team;

public interface TeamService {
	Team addTeam(Team team);
	List<Team> getTeams();
	Team getTeam(int id);
}
