package com.example.networking.Model;

public class Conference {

    private String name;
    private int rank;
    private int win;
    private int loss;

    public Conference(String name, int rank, int win, int loss) {
        this.name = name;
        this.rank = rank;
        this.win = win;
        this.loss = loss;
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }

    public int getWin() {
        return win;
    }

    public int getLoss() {
        return loss;
    }
}
