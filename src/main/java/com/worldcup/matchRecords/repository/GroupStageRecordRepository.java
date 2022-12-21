package com.worldcup.matchRecords.repository;

import com.worldcup.matchRecords.model.GroupStageRecord;
import org.springframework.data.repository.CrudRepository;

import javax.swing.*;
import java.util.List;

public interface GroupStageRecordRepository extends CrudRepository<GroupStageRecord, Integer> {

    GroupStageRecord findByHomeTeamAndAwayTeam(String homeTeam, String awayTeam);

}
