package com.worldcup.matchRecords.repository;

import com.worldcup.matchRecords.model.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeamRepository extends CrudRepository<Team, Integer> {

    List<Team> findByTeamGroup(String teamGroup);

    Team findByTeamName(String teamName);

}
