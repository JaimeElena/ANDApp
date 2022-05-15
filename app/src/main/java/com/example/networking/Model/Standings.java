package com.example.networking.Model;

import java.util.ArrayList;

public class Standings {
    public String teamId;
    public String win;
    public String loss;
    public String winPct;
    public String lastTenWin;
    public String lastTenLoss;
    public String streak;
    public String confRank;

    public Standings() {

    }

    public ArrayList<Standings> getStandings() {
       // return new RetrieveStandings.getStandings(); // this has to be updated
        return null;
    }

    public String getTeamId() {
        return teamId;
    }

    public String getWin() {
        return win;
    }

    public String getLoss() {
        return loss;
    }

    public String getWinPct() {
        return winPct;
    }

    public String getLastTenWin() {
        return lastTenWin;
    }

    public String getLastTenLoss() {
        return lastTenLoss;
    }

    public String getStreak() {
        return streak;
    }

    public String getConfRank() {
        return confRank;
    }
}
