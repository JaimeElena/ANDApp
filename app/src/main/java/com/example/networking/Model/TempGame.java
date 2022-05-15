package com.example.networking.Model;

public class TempGame
{
    private int id;
    private String league;
    private String season;
    private Score scores;

    public TempGame(int id, String league, String season, Score scores) {
        this.id = id;
        this.league = league;
        this.season = season;
        this.scores = scores;
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

    public String toString()
    {
        return "Id: " + id + " League: " + league + " Season: " + season  + " Visitor score: " + scores.getVisitors().getPoints() + " Locals score: " + scores.getLocals().getPoints();
    }
}
