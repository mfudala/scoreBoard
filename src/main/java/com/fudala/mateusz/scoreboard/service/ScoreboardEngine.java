package com.fudala.mateusz.scoreboard.service;

import com.fudala.mateusz.scoreboard.model.Game;
import com.fudala.mateusz.scoreboard.model.Score;

import java.util.ArrayList;
import java.util.List;

public class ScoreboardEngine {

    private final List<Game> liveGames = new ArrayList<>();

    public void startNewGame(final Game game) {
        if (game.isInProgress()) {
            throw new IllegalStateException("Cannot start game, it has been already started.");
        }
        game.startGame();
        liveGames.add(game);
    }

    public void finishGame(final Game game) {
        if (game.isFinished()) {
            throw new IllegalStateException("Cannot finish game, it has been already finished");
        }
        game.finishGame();
        liveGames.remove(game);
    }

    public void updateScore(final Score homeTeamScore, final Score awayTeamScore) {
    }

    public List<Game> getSummaryOfGamesInProgress() {
        return liveGames;
    }
}
