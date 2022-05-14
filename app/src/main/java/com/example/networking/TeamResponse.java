package com.example.networking;

import com.example.networking.Model.Team;

public class TeamResponse
{
    private int id;
    private String name;
    private String nickname;
    private String code;
    private String logo;
    private String city;
    private String conference;

    public Team getTeam()
    {
        return new Team(id, name, nickname, code, logo, city, conference);
    }
}
