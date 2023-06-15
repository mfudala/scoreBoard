package com.fudala.mateusz.scoreboard.service.comparator;

import com.fudala.mateusz.scoreboard.model.Game;
import com.fudala.mateusz.scoreboard.model.GameResult;

import java.util.Comparator;

public class GameComparator implements Comparator<Game> {

    public int compare(final Game firstGame, final Game secondGame) {

        var firstGameResult = firstGame.getGameResult();
        var secondGameResult = secondGame.getGameResult();

        var aggregatedFirstGameScore = getAggregatedScoreFromGameResult(firstGameResult);
        var aggregatedSecondGameScore = getAggregatedScoreFromGameResult(secondGameResult);

        if (aggregatedSecondGameScore == aggregatedFirstGameScore) {
            // Scores are equal, sort by startTime in descending order
            return secondGame.getStartTime().compareTo(firstGame.getStartTime());
        }

        // Sort by aggregated score in descending order
        return Integer.compare(aggregatedSecondGameScore, aggregatedFirstGameScore);
    }

    private int getAggregatedScoreFromGameResult(final GameResult gameResult) {
        return gameResult.getHomeTeamScore() + gameResult.getAwayTeamScore();
    }

}
