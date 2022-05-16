package com.example.networking.Model;

import com.example.networking.Model.Team;

import java.util.ArrayList;

public class TeamResponse
{
    private ArrayList<Team> teamList = new ArrayList<Team>();


    public ArrayList<Team> getTeam()
    {
        return teamList;
    }

    public String toString()
    {
        return String.format("Teams name: ");
    }
}
