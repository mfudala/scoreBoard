package com.fudala.mateusz.scoreboard.service;

import com.fudala.mateusz.scoreboard.model.Game;

public class GameStateValidator {

    public void validateIfGameCanBeStarted(final Game game) {
        if (game.isInProgress()) {
            throw new IllegalStateException("Cannot start game, it has been already started.");
        }
    }

    public void validateIfGameCanBeFinished(final Game game) {
        if (!game.isInProgress()) {
            throw new IllegalStateException("Cannot finish game that is not started.");
        }
        if (game.isFinished()) {
            throw new IllegalStateException("Cannot finish game that has been already finished.");
        }
    }

    public void validateIfGameIsInProgress(final Game game) {
        if (!game.isInProgress()) {
            throw new IllegalStateException("Match fixing check! ( ͡° ͜ʖ ͡°). " +
                    "Cannot edit score of game that is not in progress.");
        }
    }
}
