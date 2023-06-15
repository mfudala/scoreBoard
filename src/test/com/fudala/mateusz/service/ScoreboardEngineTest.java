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
        var game = getNewTestGame();

        // when
        serviceUnderTest.startNewGame(game);
        var gamesInProgress = serviceUnderTest.getSummaryOfGamesInProgress();

        // then
        assertThat(gamesInProgress).contains(game);
        assertTrue(game.isInProgress());
        assertFalse(game.isFinished());
    }

    @Test
    void shouldThrowAnExceptionWhenStartingGameInProgress() {
        // given
        var game = getNewTestGame();
        serviceUnderTest.startNewGame(game);

        // when && then
        assertThrows(IllegalStateException.class, () -> serviceUnderTest.startNewGame(game));
    }

    @Test
    void shouldUpdateScore() {

    }

    @Test
    void shouldFinishGame() {
        // given
        var game = getNewTestGame();
        serviceUnderTest.startNewGame(game);

        // when
        serviceUnderTest.finishGame(game);
        var gamesInProgress = serviceUnderTest.getSummaryOfGamesInProgress();

        // then
        assertThat(gamesInProgress).doesNotContain(game);
        assertFalse(game.isInProgress());
        assertTrue(game.isFinished());
    }

    @Test
    void shouldThrowAnExceptionWhenFinishingGameThatIsAlreadyCompleted() {
        // given
        var game = getNewTestGame();
        serviceUnderTest.startNewGame(game);
        serviceUnderTest.finishGame(game);

        // when && then
        assertThrows(IllegalStateException.class, () -> serviceUnderTest.finishGame(game));
    }

    @Test
    void shouldGetSummaryOfGamesOrderedByTotalScore() {

    }

    @Test
    void shouldGetSummaryOfGamesOrderedStartTimeWhenTotalScoreIsEqual() {

    }

    private static Game getNewTestGame() {
        var homeTeam = new Team("Redania");
        var awayTeam = new Team("Aedirn");
        return new Game(homeTeam, awayTeam);
    }

}