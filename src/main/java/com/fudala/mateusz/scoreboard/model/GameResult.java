package com.fudala.mateusz.scoreboard.model;

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
}
