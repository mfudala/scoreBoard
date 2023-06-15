package com.fudala.mateusz.scoreboard.model;

public class GameResult {

    private final Score homeTeamScore;
    private final Score awayTeamScore;

    public GameResult(final Score homeTeamScore, final Score awayTeamScore) {
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
    }

    public Score getHomeTeamScore() {
        return homeTeamScore;
    }

    public Score getAwayTeamScore() {
        return awayTeamScore;
    }
}
