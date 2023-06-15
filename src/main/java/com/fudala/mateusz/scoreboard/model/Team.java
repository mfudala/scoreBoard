package com.fudala.mateusz.scoreboard.model;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return teamScore == team.teamScore &&
                Objects.equals(teamName, team.teamName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamName, teamScore);
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", teamScore=" + teamScore +
                '}';
    }
}
