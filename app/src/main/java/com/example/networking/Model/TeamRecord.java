package com.example.networking.Model;

import java.io.Serializable;

public class TeamRecord implements Serializable
{
    private int win;
    private int loss;
    private int points;

    public TeamRecord(int win, int loss, int points) {
        this.win = win;
        this.loss = loss;
        this.points = points;
    }

    public int getWin()
    {
        return win;
    }

    public int getLoss()
    {
        return loss;
    }

    public String getPoints()
    {
        return String.valueOf(points);
    }

    @Override
    public String toString() {
        return String.valueOf(points);
    }
}
