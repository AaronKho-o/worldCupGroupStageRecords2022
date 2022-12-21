package com.worldcup.matchRecords.service;

import com.worldcup.matchRecords.model.Team;
import com.worldcup.matchRecords.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {

    private TeamRepository teamRepository;

    @Autowired
    public void setTeamsRepository(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Object findAll() {
        return this.teamRepository.findAll();
    }

    public Object findByTeamGroup(String teamGroup) {
        return this.teamRepository.findByTeamGroup(teamGroup);
    }

    public Team findByTeamName(String teamName) {
        return this.teamRepository.findByTeamName(teamName);
    }

    public void save(Team team) {
        this.teamRepository.save(team);
    }

    public void setPoints(Team team) {
        Team teamToBeUpdated = this.teamRepository.findByTeamName(team.getTeamName());
        teamToBeUpdated.setPoints(team.getPoints());
        this.save(teamToBeUpdated);
    }

    public void setPoints(Team team, Integer points) {
        Team teamToBeUpdated = this.teamRepository.findByTeamName(team.getTeamName());
        teamToBeUpdated.setPoints(team.getPoints() + points);
        this.save(teamToBeUpdated);
    }

    public Integer getPoints(Team team) {
        this.teamRepository.findByTeamName(team.getTeamName());
        return team.getPoints();
    }

}
