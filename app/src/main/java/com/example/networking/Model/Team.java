package com.example.networking.Model;

public class Team
{
    private final int id;
    private final String name;
    private final String nickname;
    private final String code;
    private final String logo;
    private final String city;
    private final String conference;

    public Team(int id, String name, String nickname, String code, String logo, String city, String conference)
    {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.code = code;
        this.logo = logo;
        this.city = city;
        this.conference = conference;
    }


    public String getNickname() {
        return nickname;
    }

    public String getCode() {
        return code;
    }

    public String getLogo() {
        return logo;
    }

    public String getCity() {
        return city;
    }

    public String getConference() {
        return conference;
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
