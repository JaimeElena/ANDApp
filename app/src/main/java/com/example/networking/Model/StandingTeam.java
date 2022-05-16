package com.example.networking.Model;

public class StandingTeam implements Comparable<StandingTeam> {

    private Team team;
    private Conference conference;

    public StandingTeam(Team team, Conference conference) {
        this.team = team;
        this.conference = conference;
    }

    public Team getTeam() {
        return team;
    }

    public Conference getConference() {
        return conference;
    }

    public String toString()
    {
        return "                " + team.getName() + "        " + conference.getRank() + "        " + conference.getWin() + "        " + conference.getLoss();
    }

    @Override
    public int compareTo(StandingTeam standingTeam) {
        int comparaege = ((StandingTeam)standingTeam).getConference().getRank();
        return this.getConference().getRank() - comparaege;
    }
}
