package com.fudala.mateusz.scoreboard.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(teamName, team.teamName) && Objects.equals(teamScore, team.teamScore);
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
