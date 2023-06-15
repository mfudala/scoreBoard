package com.fudala.mateusz.scoreboard.service.validator;

import com.fudala.mateusz.scoreboard.model.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameStateValidatorTest {

    private GameStateValidator serviceUnderTest;

    @BeforeEach
    void setup() {
        serviceUnderTest = new GameStateValidator();
    }

    @Test
    void shouldThrowAnExceptionWhenValidatingGameInProgressForNewGame() {
        // given
        var game = new Game("Temeria", "Skellige");

        // when && then
        assertThrows(IllegalStateException.class, () -> serviceUnderTest.validateIfGameIsInProgress(game));
    }

    @Test
    void shouldNotThrowAnExceptionWhenValidatingGameInProgressForOngoingGame() {
        // given
        var game = new Game("Temeria", "Skellige");

        // when
        game.startGame();

        // then
        assertDoesNotThrow(() -> serviceUnderTest.validateIfGameIsInProgress(game));
    }


    @Test
    void shouldThrowAnExceptionWhenValidatingGameToBeFinishedForNewGame() {
        // given
        var game = new Game("Temeria", "Skellige");

        // when && then
        assertThrows(IllegalStateException.class, () -> serviceUnderTest.validateIfGameCanBeFinished(game));
    }

    @Test
    void shouldThrowAnExceptionWhenValidatingGameToBeFinishedForFinishedGame() {
        // given
        var game = new Game("Temeria", "Skellige");
        game.startGame();
        game.finishGame();

        // when && then
        assertThrows(IllegalStateException.class, () -> serviceUnderTest.validateIfGameCanBeFinished(game));
    }

    @Test
    void shouldNotThrowAnExceptionWhenValidatingGameToBeFinishedForOngoingGame() {
        // given
        var game = new Game("Temeria", "Skellige");

        // when
        game.startGame();

        // then
        assertDoesNotThrow(() -> serviceUnderTest.validateIfGameCanBeFinished(game));
    }

    @Test
    void shouldThrowAnExceptionWhenValidatingIfGameIsInProgressForNewGame() {
        // given
        var game = new Game("Temeria", "Skellige");

        // when && then
        assertThrows(IllegalStateException.class, () -> serviceUnderTest.validateIfGameIsInProgress(game));
    }

    @Test
    void shouldThrowAnExceptionWhenValidatingIfGameIsInProgressForFinishedGame() {
        // given
        var game = new Game("Temeria", "Skellige");
        game.startGame();
        game.finishGame();

        // when && then
        assertThrows(IllegalStateException.class, () -> serviceUnderTest.validateIfGameIsInProgress(game));
    }

    @Test
    void shouldNotThrowAnExceptionWhenValidatingIfGameIsInProgressForOngoingGame() {
        // given
        var game = new Game("Temeria", "Skellige");

        // when
        game.startGame();

        // then
        assertDoesNotThrow(() -> serviceUnderTest.validateIfGameIsInProgress(game));
    }
}