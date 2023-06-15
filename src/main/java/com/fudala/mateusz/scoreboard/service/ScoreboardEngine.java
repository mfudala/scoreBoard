package main.java.com.fudala.mateusz.scoreboard.service;

import main.java.com.fudala.mateusz.scoreboard.model.Game;
import main.java.com.fudala.mateusz.scoreboard.model.Score;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreboardEngine {

    private final List<Game> liveGames = new ArrayList<>();

    public void startNewGame(final Game game) {
    }

    public void finishGame(final Game game) {
    }

    public void updateScore(final Score homeTeamScore, final Score awayTeamScore) {
    }

    public List<Game> getSummaryOfGamesInProgress() {
        return Collections.emptyList();
    }
}
