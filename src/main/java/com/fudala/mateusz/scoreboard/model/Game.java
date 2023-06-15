package com.fudala.mateusz.scoreboard.model;

import java.time.LocalDateTime;

public class Game {
    
    private final Team homeTeam;
    private final Team awayTeam;
    private LocalDateTime startTime;
    private boolean isFinished;

    public Game(final Team homeTeam, final Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
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
}
