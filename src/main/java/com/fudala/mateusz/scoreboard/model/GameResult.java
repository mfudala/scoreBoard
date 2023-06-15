package com.fudala.mateusz.scoreboard.model;

import java.util.Objects;

public class GameResult {

    private final int homeTeamScore;
    private final int awayTeamScore;

    public GameResult(final int homeTeamScore, final int awayTeamScore) {
        validateScore(homeTeamScore);
        validateScore(awayTeamScore);
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    private void validateScore(final int teamScore) {
        if (teamScore < 0) {
            throw new IllegalArgumentException(String.format(
                    "Score cannot be negative, provided score value: {%d}", teamScore));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return homeTeamScore == that.homeTeamScore &&
                awayTeamScore == that.awayTeamScore;
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeamScore, awayTeamScore);
    }

    @Override
    public String toString() {
        return "GameResult{" +
                "homeTeamScore=" + homeTeamScore +
                ", awayTeamScore=" + awayTeamScore +
                '}';
    }
}
