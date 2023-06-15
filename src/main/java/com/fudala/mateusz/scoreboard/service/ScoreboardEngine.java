package com.fudala.mateusz.scoreboard.service;

import com.fudala.mateusz.scoreboard.model.Game;
import com.fudala.mateusz.scoreboard.model.GameResult;
import com.fudala.mateusz.scoreboard.service.comparator.GameComparator;
import com.fudala.mateusz.scoreboard.service.validator.GameStateValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreboardEngine {

    private final GameStateValidator gameStateValidator;
    private final List<Game> liveGames;

    public ScoreboardEngine() {
        this.gameStateValidator = new GameStateValidator();
        this.liveGames = new ArrayList<>();
    }

    public void startNewGame(final Game game) {
        gameStateValidator.validateIfGameCanBeStarted(game);
        game.startGame();
        liveGames.add(game);
    }

    public void finishGame(final Game game) {
        gameStateValidator.validateIfGameCanBeFinished(game);
        game.finishGame();
        liveGames.remove(game);
    }

    public void updateScore(final Game game, final GameResult gameResult) {
        gameStateValidator.validateIfGameIsInProgress(game);
        game.updateGameScore(gameResult);
    }

    public List<Game> getSummaryOfGamesInProgress() {
        return getGamesSortedByTotalCountAndStartTimeDescending(liveGames);
    }

    private List<Game> getGamesSortedByTotalCountAndStartTimeDescending(final List<Game> liveGames) {
        return liveGames.stream()
                .sorted(new GameComparator())
                .collect(Collectors.toList());
    }
}
