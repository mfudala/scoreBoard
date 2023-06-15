package com.fudala.mateusz.scoreboard.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Game {

    private final Team homeTeam;
    private final Team awayTeam;
    private LocalDateTime startTime;
    private boolean isFinished;

    public Game(final String homeTeamName, final String awayTeamName) {
        this.homeTeam = new Team(homeTeamName);
        this.awayTeam = new Team(awayTeamName);
    }

    public LocalDateTime getStartTime() {
        return startTime;
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

    public GameResult getGameResult() {
        var homeTeamScore = homeTeam.getTeamScore();
        var awayTeamScore = awayTeam.getTeamScore();
        return new GameResult(homeTeamScore, awayTeamScore);
    }

    public void updateGameScore(final GameResult gameResult) {
        homeTeam.setTeamScore(gameResult.getHomeTeamScore());
        awayTeam.setTeamScore(gameResult.getAwayTeamScore());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return isFinished == game.isFinished &&
                Objects.equals(homeTeam, game.homeTeam) &&
                Objects.equals(awayTeam, game.awayTeam) &&
                Objects.equals(startTime, game.startTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeam, awayTeam, startTime, isFinished);
    }

    @Override
    public String toString() {
        return homeTeam.getTeamName() + " " + homeTeam.getTeamScore() + " : " +
                awayTeam.getTeamName() + " " + awayTeam.getTeamScore();
    }
}
