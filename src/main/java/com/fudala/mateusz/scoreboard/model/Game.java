package main.java.com.fudala.mateusz.scoreboard.model;

import java.time.LocalDateTime;

public class Game {
    
    private final Team homeTeam;
    private final Team awayTeam;
    private LocalDateTime startTime;

    public Game(final Team homeTeam, final Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }
}
