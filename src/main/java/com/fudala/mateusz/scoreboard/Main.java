package com.fudala.mateusz.scoreboard;

import com.fudala.mateusz.scoreboard.model.Game;
import com.fudala.mateusz.scoreboard.model.GameResult;
import com.fudala.mateusz.scoreboard.service.ScoreboardEngine;

public class Main {
    public static void main(String[] args) {
        var scoreboardEngine = new ScoreboardEngine();

        var mexicoCanada = new Game("Mexico", "Canada");
        var spainBrazil = new Game("Spain", "Brazil");
        var germanyFrance = new Game("Germany", "France");
        var uruguayItaly = new Game("Uruguay", "Italy");
        var argentinaAustralia = new Game("Argentina", "Australia");

        scoreboardEngine.startNewGame(mexicoCanada);
        scoreboardEngine.startNewGame(spainBrazil);
        scoreboardEngine.startNewGame(germanyFrance);
        scoreboardEngine.startNewGame(uruguayItaly);
        scoreboardEngine.startNewGame(argentinaAustralia);

        scoreboardEngine.updateScore(mexicoCanada, new GameResult(0, 5));
        scoreboardEngine.updateScore(spainBrazil, new GameResult(10, 2));
        scoreboardEngine.updateScore(germanyFrance, new GameResult(2, 2));
        scoreboardEngine.updateScore(uruguayItaly, new GameResult(6, 6));
        scoreboardEngine.updateScore(argentinaAustralia, new GameResult(3, 1));

        System.out.println(scoreboardEngine.getSummaryOfGamesInProgress());
    }
}