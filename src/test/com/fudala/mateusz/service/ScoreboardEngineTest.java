package com.fudala.mateusz.service;

import com.fudala.mateusz.scoreboard.model.Game;
import com.fudala.mateusz.scoreboard.model.Team;
import com.fudala.mateusz.scoreboard.service.ScoreboardEngine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


class ScoreboardEngineTest {

    private ScoreboardEngine serviceUnderTest;

    @BeforeEach
    void setup() {
        serviceUnderTest = new ScoreboardEngine();
    }

    @Test
    void shouldStartNewGame() {
        // given
        var game = getNewGame();

        // when
        serviceUnderTest.startNewGame(game);
        var gamesInProgress = serviceUnderTest.getSummaryOfGamesInProgress();

        // then
        assertThat(gamesInProgress).contains(game);
        assertTrue(game.isInProgress());
        assertFalse(game.isFinished());
    }

    @Test
    void shouldThrowAnExceptionWhenStartingGameInProgess() {
        // given
        var game = getNewGame();

        // when
        serviceUnderTest.startNewGame(game);

        // then
        assertThrows(IllegalStateException.class, () -> serviceUnderTest.startNewGame(game));
    }

    @Test
    void shouldUpdateScore() {

    }

    @Test
    void shouldFinishGame() {
        // given
        var game = getNewGame();
        serviceUnderTest.startNewGame(game);

        // when
        serviceUnderTest.finishGame(game);

        // then
        assertFalse(game.isInProgress());
        assertTrue(game.isFinished());
    }

    @Test
    void shouldGetSummaryOfGamesOrderedByTotalScore() {

    }

    @Test
    void shouldGetSummaryOfGamesOrderedStartTimeWhenTotalScoreIsEqual() {

    }

    private static Game getNewGame() {
        var homeTeam = new Team("Redania");
        var awayTeam = new Team("Aedirn");
        return new Game(homeTeam, awayTeam);
    }

}