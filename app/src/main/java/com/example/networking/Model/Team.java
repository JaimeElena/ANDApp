package com.example.networking.Model;

import com.google.gson.annotations.SerializedName;

public class Team
{
    private int id;

    @SerializedName("name")
    private String name;

    private String nickname;

    private String code;

    private String city;

    public Team(int id, String name, String nickname, String code, String city)
    {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.code = code;
        this.city = city;
    }


    public String getNickname() {
        return nickname;
    }

    public String getCode() {
        return code;
    }


    public String getCity() {
        return city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String toString()
    {
        return String.format(name);
    }
}
