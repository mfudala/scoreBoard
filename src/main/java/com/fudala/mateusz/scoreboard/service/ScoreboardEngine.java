package com.fudala.mateusz.scoreboard.service;

import com.fudala.mateusz.scoreboard.model.Game;
import com.fudala.mateusz.scoreboard.model.GameResult;
import com.fudala.mateusz.scoreboard.model.Score;

import java.util.ArrayList;
import java.util.List;

public class ScoreboardEngine {

    private final List<Game> liveGames = new ArrayList<>();

    public void startNewGame(final Game game) {
        validateIfGameCanBeStarted(game);
        game.startGame();
        liveGames.add(game);
    }

    public void finishGame(final Game game) {
        validateIfGameCanBeFinished(game);
        game.finishGame();
        liveGames.remove(game);
    }

    public void updateScore(final Game game, final GameResult gameResult) {
        validateIfGameIsInProgress(game);
        game.updateGameScore(gameResult);
    }

    public List<Game> getSummaryOfGamesInProgress() {
        return List.copyOf(liveGames);
    }

    private static void validateIfGameCanBeStarted(final Game game) {
        if (game.isInProgress()) {
            throw new IllegalStateException("Cannot start game, it has been already started.");
        }
    }

    private static void validateIfGameCanBeFinished(final Game game) {
        if (game.isFinished()) {
            throw new IllegalStateException("Cannot finish game, it has been already finished");
        }
    }

    private void validateIfGameIsInProgress(final Game game) {
        if (!game.isInProgress()) {
            throw new IllegalStateException("Match fixing check! ( ͡° ͜ʖ ͡°). " +
                    "Cannot edit score of game that is not in progress.");
        }
    }
}
