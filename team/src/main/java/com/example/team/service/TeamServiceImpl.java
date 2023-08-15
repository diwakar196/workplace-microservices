package com.example.team.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.team.entity.Team;

@Service
public class TeamServiceImpl implements TeamService {
	
	private static final Logger logger = LoggerFactory.getLogger(TeamServiceImpl.class);
	
	private List<Team> teamList;
	
	public TeamServiceImpl() {
		this.teamList = new ArrayList<>();
	}

	@Override
	@KafkaListener(topics = "team_topic", groupId = "teamGroup")
	public Team addTeam(Team team) {
		logger.info("Team has been added to the list");
		this.teamList.add(new Team(team.getId(), team.getName()));
		return team;
	}

	@Override
	public List<Team> getTeams() {
		return this.teamList;
	}

	@Override
	public Team getTeam(int id) {
		return this.teamList.stream().filter((team) -> team.getId()==id).findFirst().orElse(null);
	}

}
