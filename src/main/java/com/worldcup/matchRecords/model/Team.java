package com.worldcup.matchRecords.model;

import jakarta.persistence.*;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teamId")
    private Integer id;

    @Column(name = "teamName", nullable = false)
    private String teamName;

    @Column(name = "teamGroup", nullable = false)
    private String teamGroup;

    @Column(name = "points", nullable = false)
    private Integer points;

    public Team() {}

    public Team(String teamName, String teamGroup, Integer points) {
        this.teamName = teamName;
        this.teamGroup = teamGroup;
        this.points = points;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamGroup() {
        return teamGroup;
    }

    public void setTeamGroup(String teamGroup) {
        this.teamGroup = teamGroup;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
