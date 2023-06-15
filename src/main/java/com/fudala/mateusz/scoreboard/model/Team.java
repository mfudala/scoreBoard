package com.fudala.mateusz.scoreboard.model;

public class Team {

    private final String teamName;
    private int teamScore;

    public Team(final String teamName) {
        this.teamName = teamName;
    }

    public void setTeamScore(final int teamScore) {
        this.teamScore = teamScore;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getTeamScore() {
        return teamScore;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", teamScore=" + teamScore +
                '}';
    }
}
