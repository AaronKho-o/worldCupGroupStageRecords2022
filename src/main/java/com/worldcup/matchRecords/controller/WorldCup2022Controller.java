package com.worldcup.matchRecords.controller;

import com.worldcup.matchRecords.model.GroupStageRecord;
import com.worldcup.matchRecords.model.Team;
import com.worldcup.matchRecords.service.GroupStageRecordServiceImpl;
import com.worldcup.matchRecords.service.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class WorldCup2022Controller {

    private TeamServiceImpl teamServiceImpl;
    private GroupStageRecordServiceImpl groupStageRecordServiceImpl;

    private List<String> teamGroups = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H");

    @Autowired
    public void setTeamsService(TeamServiceImpl teamsServiceImpl) {
        this.teamServiceImpl = teamsServiceImpl;
    }

    @Autowired
    public void setGroupStageRecordsService(GroupStageRecordServiceImpl groupStageRecordServiceImpl) {
        this.groupStageRecordServiceImpl = groupStageRecordServiceImpl;
    }

    @GetMapping("/teams")
    public String retrieveTeams(Model model) {
        for (String teamGroup: teamGroups) {
            model.addAttribute(teamGroup, this.teamServiceImpl.findByTeamGroup(teamGroup));
        }
        model.addAttribute("fullTeamList", this.teamServiceImpl.findAll());
        model.addAttribute("newTeam", new Team());
        return "teams";
    }

    @GetMapping("/groupStageRecords")
    public String retrieveGroupStageRecords(Model model) {
        model.addAttribute("groupStageRecords", groupStageRecordServiceImpl.findAll());
        model.addAttribute("fullTeamList", this.teamServiceImpl.findAll());
        model.addAttribute("newGroupStageRecord", new GroupStageRecord());
        return "groupStageRecords";
    }

    @PostMapping("/teams")
    public String addTeam(@ModelAttribute("newTeam") Team newTeam, Model model) {
        teamServiceImpl.setPoints(newTeam);
        for (String teamGroup: teamGroups) {
            model.addAttribute(teamGroup, this.teamServiceImpl.findByTeamGroup(teamGroup));
        }
        model.addAttribute("fullTeamList", this.teamServiceImpl.findAll());
        model.addAttribute("newTeam", new Team());
        return "redirect:teams";
    }

    @PostMapping("/groupStageRecords")
    public String updateGroupStageResult(@ModelAttribute("newGroupStageRecord") GroupStageRecord newGroupStageRecord, Model model) {
        groupStageRecordServiceImpl.setHomeResult(newGroupStageRecord);
        model.addAttribute("groupStageRecords", groupStageRecordServiceImpl.findAll());
        model.addAttribute("newGroupStageRecord", new GroupStageRecord());
        return "redirect:groupStageRecords";
    }
}
