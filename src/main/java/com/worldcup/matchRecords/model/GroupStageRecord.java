package com.worldcup.matchRecords.model;

import jakarta.persistence.*;

@Entity
public class GroupStageRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "homeTeam", nullable = false)
    private String homeTeam;

    @Column(name = "awayTeam", nullable = false)
    private String awayTeam;

    @Column(name = "homeResult", nullable = false)
    private String homeResult;

    @Column(name = "matchGroup", nullable = false)
    private String matchGroup;

    public GroupStageRecord() {}

    public GroupStageRecord(String homeTeam, String awayTeam, String homeResult, String matchGroup) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeResult = homeResult;
        this.matchGroup = matchGroup;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getHomeResult() {
        return homeResult;
    }

    public void setHomeResult(String result) {
        this.homeResult = result;
    }

    public String getMatchGroup() {
        return matchGroup;
    }

    public void setMatchGroup(String matchGroup) {
        this.matchGroup = matchGroup;
    }
}
