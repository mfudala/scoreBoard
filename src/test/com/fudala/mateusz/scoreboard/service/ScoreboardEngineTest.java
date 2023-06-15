package com.fudala.mateusz.scoreboard.service;

import com.fudala.mateusz.scoreboard.model.Game;
import com.fudala.mateusz.scoreboard.model.GameResult;
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
        // given
        var game = getNewTestGame();
        var homeScore = 1;
        var awayScore = 0;
        serviceUnderTest.startNewGame(game);

        // when
        serviceUnderTest.updateScore(game, new GameResult(homeScore, awayScore));

        // then
        assertEquals(homeScore, game.getGameResult().getHomeTeamScore());
        assertEquals(awayScore, game.getGameResult().getAwayTeamScore());
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
    void shouldGetSummaryOfGamesSorted() {
        // given
        var mexicoCanada = new Game("Mexico", "Canada");
        var spainBrazil = new Game("Spain", "Brazil");
        var germanyFrance = new Game("Germany", "France");
        var uruguayItaly = new Game("Uruguay", "Italy");
        var argentinaAustralia = new Game("Argentina", "Australia");

        serviceUnderTest.startNewGame(mexicoCanada);
        serviceUnderTest.startNewGame(spainBrazil);
        serviceUnderTest.startNewGame(germanyFrance);
        serviceUnderTest.startNewGame(uruguayItaly);
        serviceUnderTest.startNewGame(argentinaAustralia);

        serviceUnderTest.updateScore(mexicoCanada, new GameResult(0, 5));
        serviceUnderTest.updateScore(spainBrazil, new GameResult(10, 2));
        serviceUnderTest.updateScore(germanyFrance, new GameResult(2, 2));
        serviceUnderTest.updateScore(uruguayItaly, new GameResult(6, 6));
        serviceUnderTest.updateScore(argentinaAustralia, new GameResult(3, 1));

        // when
        var gamesInProgress = serviceUnderTest.getSummaryOfGamesInProgress();

        // then
        assertThat(gamesInProgress).containsExactly(
                uruguayItaly, spainBrazil, mexicoCanada, argentinaAustralia, germanyFrance);
    }

    private static Game getNewTestGame() {
        return new Game("Redania", "Aedirn");
    }

}