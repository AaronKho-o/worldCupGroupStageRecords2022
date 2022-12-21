package com.worldcup.matchRecords.service;

import com.worldcup.matchRecords.model.GroupStageRecord;
import com.worldcup.matchRecords.repository.GroupStageRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupStageRecordServiceImpl {

    private GroupStageRecordRepository groupStageRecordRepository;
    private TeamServiceImpl teamServiceImpl;

    @Autowired
    public void setGroupStageRecordRepository(GroupStageRecordRepository groupStageRecordRepository) {
        this.groupStageRecordRepository = groupStageRecordRepository;
    }

    @Autowired
    public void setTeamServiceImpl(TeamServiceImpl teamServiceImpl) {
        this.teamServiceImpl = teamServiceImpl;
    }

    public Object findAll() {
        return this.groupStageRecordRepository.findAll();
    }

    public void save(GroupStageRecord groupStageRecord) {this.groupStageRecordRepository.save(groupStageRecord);}

    public void setHomeResult(GroupStageRecord groupStageRecord) {
        GroupStageRecord groupStageRecordToBeUpdated = this.groupStageRecordRepository.findByHomeTeamAndAwayTeam(groupStageRecord.getHomeTeam(), groupStageRecord.getAwayTeam());
        String result = groupStageRecord.getHomeResult();
        groupStageRecordToBeUpdated.setHomeResult(result);
        this.save(groupStageRecordToBeUpdated);

        if (result.equals("WIN")) {
            this.teamServiceImpl.setPoints(this.teamServiceImpl.findByTeamName(groupStageRecordToBeUpdated.getHomeTeam()), 3);
        } else if (result.equals("LOSS")) {
            this.teamServiceImpl.setPoints(this.teamServiceImpl.findByTeamName(groupStageRecordToBeUpdated.getAwayTeam()), 3);
        } else if (result.equals("DRAW")) {
            this.teamServiceImpl.setPoints(this.teamServiceImpl.findByTeamName(groupStageRecordToBeUpdated.getHomeTeam()), 1);
            this.teamServiceImpl.setPoints(this.teamServiceImpl.findByTeamName(groupStageRecordToBeUpdated.getAwayTeam()), 1);
        }
    }
}
