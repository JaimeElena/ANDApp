package com.example.networking.Model;

public class Teams
{
    private Team visitors;
    private Team home;


    public Teams(Team visitors, Team home) {
        this.visitors = visitors;
        this.home = home;
    }

    public Team getVisitor() {
        return visitors;
    }

    public Team getLocal() {
        return home;
    }
}
