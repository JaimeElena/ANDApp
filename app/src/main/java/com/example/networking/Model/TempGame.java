package com.example.networking.Model;

import java.io.Serializable;

public class TempGame implements Serializable
{
    private int id;
    private String league;
    private String season;
    private Score scores;
    private Teams teams;

    public TempGame(int id, String league, String season, Score scores, Teams teams) {
        this.id = id;
        this.league = league;
        this.season = season;
        this.scores = scores;
        this.teams = teams;
    }

    public int getId() {
        return id;
    }

    public String getLeague() {
        return league;
    }

    public String getSeason() {
        return season;
    }

    public Score getScores() {
        return scores;
    }

    public Teams getTeams() {
        return teams;
    }

    public String toString()
    {
        return teams.getVisitor().getName()  +  " " + scores.getVisitors().getPoints() + " - "  + teams.getLocal().getName() + " "+ scores.getLocals().getPoints();
    }
}
