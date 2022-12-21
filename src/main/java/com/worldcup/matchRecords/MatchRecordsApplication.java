package com.worldcup.matchRecords;

import com.worldcup.matchRecords.model.GroupStageRecord;
import com.worldcup.matchRecords.model.Team;
import com.worldcup.matchRecords.repository.GroupStageRecordRepository;
import com.worldcup.matchRecords.repository.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MatchRecordsApplication {
	private static final Logger log = LoggerFactory.getLogger(MatchRecordsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MatchRecordsApplication.class, args);
	}

	@Bean
	public CommandLineRunner temp(TeamRepository teams_repository, GroupStageRecordRepository groupStageRecordRepository) {
		return (args) -> {
			teams_repository.save(new Team("Qatar", "A", 0));
			teams_repository.save(new Team("Ecuador", "A", 0));
			teams_repository.save(new Team("Senegal", "A", 0));
			teams_repository.save(new Team("Netherlands", "A", 0));
			teams_repository.save(new Team("England", "B", 0));
			teams_repository.save(new Team("IR Iran", "B", 0));
			teams_repository.save(new Team("USA", "B", 0));
			teams_repository.save(new Team("Wales", "B", 0));
			teams_repository.save(new Team("Argentina", "C", 0));
			teams_repository.save(new Team("Saudi Arabia", "C", 0));
			teams_repository.save(new Team("Mexico", "C", 0));
			teams_repository.save(new Team("Poland", "C", 0));
			teams_repository.save(new Team("France", "D", 0));
			teams_repository.save(new Team("Australia", "D", 0));
			teams_repository.save(new Team("Denmark", "D", 0));
			teams_repository.save(new Team("Tunisia", "D", 0));
			teams_repository.save(new Team("Spain", "E", 0));
			teams_repository.save(new Team("Costa Rica", "E", 0));
			teams_repository.save(new Team("Germany", "E", 0));
			teams_repository.save(new Team("Japan", "E", 0));
			teams_repository.save(new Team("Belgium", "F", 0));
			teams_repository.save(new Team("Canada", "F", 0));
			teams_repository.save(new Team("Morocco", "F", 0));
			teams_repository.save(new Team("Croatia", "F", 0));
			teams_repository.save(new Team("Brazil", "G", 0));
			teams_repository.save(new Team("Serbia", "G", 0));
			teams_repository.save(new Team("Switzerland", "G", 0));
			teams_repository.save(new Team("Cameroon", "G", 0));
			teams_repository.save(new Team("Portugal", "H", 0));
			teams_repository.save(new Team("Ghana", "H", 0));
			teams_repository.save(new Team("Uruguay", "H", 0));
			teams_repository.save(new Team("Korea Republic", "H", 0));

			List<String> groups = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H");

			for (String group: groups) {
				for (Team home_team: teams_repository.findByTeamGroup(group)) {
					for (Team away_team : teams_repository.findByTeamGroup(group)) {
						if (groupStageRecordRepository.findByHomeTeamAndAwayTeam(home_team.getTeamName(), away_team.getTeamName()) == null && groupStageRecordRepository.findByHomeTeamAndAwayTeam(away_team.getTeamName(), home_team.getTeamName()) == null && home_team.getTeamName() != away_team.getTeamName()) {
							groupStageRecordRepository.save(new GroupStageRecord(home_team.getTeamName(), away_team.getTeamName(), "Not Updated", home_team.getTeamGroup()));
						}
					}
				}
			}

			for (Team team: teams_repository.findAll()) {
				log.info(String.format("Team %s is %s", team.getId(), team.getTeamName()));
			}

			for (GroupStageRecord groupStageRecord : groupStageRecordRepository.findAll()) {
				log.info(String.format("Match %s is between %s and %s", groupStageRecord.getId(), groupStageRecord.getHomeTeam(), groupStageRecord.getAwayTeam()));
			}
		};
	}
}
