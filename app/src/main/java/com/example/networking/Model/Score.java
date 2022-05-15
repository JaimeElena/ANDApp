package com.example.networking.Model;

public class Score {

    private TeamRecord visitors;
    private TeamRecord home;

    public Score(TeamRecord visitors, TeamRecord home) {
        this.visitors = visitors;
        this.home = home;
    }

    public TeamRecord getVisitors() {
        return visitors;
    }

    public TeamRecord getLocals() {
        return home;
    }
}
