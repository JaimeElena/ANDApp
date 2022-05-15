package com.example.networking.Model;

public class Game {

    private Teams teams;
    private Score scores;

    public Game(Teams teams, Score scores) {
        this.teams = teams;
        this.scores = scores;
    }

    public Teams getTeams() {
        return teams;
    }

    public Score getScores() {
        return scores;
    }
}
