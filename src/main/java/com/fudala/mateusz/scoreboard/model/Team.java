package com.fudala.mateusz.scoreboard.model;

public class Team {

    private final String teamName;
    private Score teamScore;

    public Team(final String teamName) {
        this.teamName = teamName;
    }

    public void setTeamScore(final Score teamScore) {
        this.teamScore = teamScore;
    }

    public String getTeamName() {
        return teamName;
    }

    public Score getTeamScore() {
        return teamScore;
    }

}
