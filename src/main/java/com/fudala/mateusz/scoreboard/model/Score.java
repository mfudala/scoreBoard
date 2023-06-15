package main.java.com.fudala.mateusz.scoreboard.model;

public class Score {
    private int homeTeamScore = 0;
    private int awayTeamScore = 0;

    public void homeTeamGoal() {
        this.homeTeamScore++;
    }

    public void awayTeamGoal() {
        this.awayTeamScore++;
    }
}
