package com.fudala.mateusz.scoreboard.model;

import java.util.Objects;

public class Score {

    private final int teamScore;

    public Score(final int teamScore) {
        validateScore(teamScore);
        this.teamScore = teamScore;
    }

    private void validateScore(final int teamScore) {
        if (teamScore < 0) {
            throw new IllegalArgumentException(String.format(
                    "Score cannot be negative, provided score value: {%d}", teamScore));
        }
    }

    public int getTeamScore() {
        return teamScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return teamScore == score.teamScore;
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamScore);
    }

    @Override
    public String toString() {
        return "Score{" +
                "homeTeamScore=" + teamScore +
                '}';
    }
}
