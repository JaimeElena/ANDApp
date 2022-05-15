package com.example.networking.Model;

import java.util.ArrayList;
import java.util.List;

public class ResponseClass {
    List<Team> response = new ArrayList<>();


    public ResponseClass(List<Team> response) {
        this.response = response;
    }

    public List<Team> getResponse() {
        return response;
    }

    public String toString()
    {
        String result = new String();
        for(Team team: response)
        {
            result += "Name: " + team.getName() + " Code: " + team.getCode() +  "\n";
        }
        return result;
    }

}
