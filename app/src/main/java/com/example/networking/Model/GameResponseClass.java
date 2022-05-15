package com.example.networking.Model;

import java.util.ArrayList;
import java.util.List;

public class GameResponseClass {

    private List<TempGame> response = new ArrayList<>();

    public GameResponseClass(List<TempGame> response) {
        this.response = response;
    }

    public List<TempGame> getGameList() {
        return response;
    }

    public String toString()
    {
        String result = new String();
        for(TempGame game: response)
        {
            result += "Game id: " + game.getId() + "\n";
        }
        return result;
    }

}
