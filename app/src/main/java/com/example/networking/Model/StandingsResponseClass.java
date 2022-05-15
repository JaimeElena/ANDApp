package com.example.networking.Model;

import java.util.List;

public class StandingsResponseClass
{
    private List<StandingTeam> response;

    public StandingsResponseClass(List<StandingTeam> response) {
        this.response = response;
    }

    public List<StandingTeam> getResponse() {
        return response;
    }

    public String toString()
        {
            String result = new String();

            for(StandingTeam team: response)
            {
                result += team.getTeam().getName() + " " + team.getConference().getRank();
            }
            return result;
        }
}
