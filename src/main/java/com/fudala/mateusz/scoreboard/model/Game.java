package com.fudala.mateusz.scoreboard.model;

import java.time.LocalDateTime;

public class Game {

    private final Team homeTeam;
    private final Team awayTeam;
    private LocalDateTime startTime;
    private boolean isFinished;

    public Game(final String homeTeamName, final String awayTeamName) {
        this.homeTeam = new Team(homeTeamName);
        this.awayTeam = new Team(awayTeamName);
    }

    public GameResult getGameResult() {
        var homeTeamScore = homeTeam.getTeamScore();
        var awayTeamScore = awayTeam.getTeamScore();
        return new GameResult(homeTeamScore, awayTeamScore);
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void updateGameScore(final GameResult gameResult) {
        homeTeam.setTeamScore(gameResult.getHomeTeamScore());
        awayTeam.setTeamScore(gameResult.getAwayTeamScore());
    }

    public void startGame() {
        startTime = LocalDateTime.now();
    }

    public void finishGame() {
        isFinished = true;
    }

    public boolean isInProgress() {
        if (isFinished) {
            return false;
        }
        return startTime != null;
    }

    public boolean isFinished() {
        return isFinished;
    }

    @Override
    public String toString() {
        return homeTeam.getTeamName() + " " + homeTeam.getTeamScore() + " : " +
                awayTeam.getTeamName() + " " + awayTeam.getTeamScore();
    }
}
