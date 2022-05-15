package com.example.networking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.networking.Model.Games;
import com.example.networking.Model.TempGame;
import com.example.networking.activities.GamesActivity;
import com.example.networking.activities.StandingsActivity;
import com.example.networking.activities.TeamsActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private BasketballViewModel viewModel;
    List<TempGame> games;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(BasketballViewModel.class);
        viewModel.getSearchedTeam().observe(this, team -> {
            System.out.println(team.getName());
        });
        searchGamesByDate();
        goToGames();
        goToStandings();
        goToTeams();
    }
    public void searchForTeam(View view)
    {
        viewModel.searchForTeam(1);
    }

    public void searchGamesByDate()
    {
        viewModel.getGamesByDate().observe(this, games ->{
            for(TempGame game: games)
            {
                games.add(game);
                System.out.println(game.getId() + " " + game.getLeague());
                // games.add(game.getTeams().getVisitor() + " " + game.getScores().getVisitors().getPoints() + " - " + game.getScores().getLocals() + " " + game.getTeams().getLocal().getName());
            }
        });
    }

    public void goToGames() {
        Button gamesButton = findViewById(R.id.gamesButton);
        gamesButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, GamesActivity.class);
            startActivity(intent);
        });
    }

    public void goToTeams() {
        Button teamsButton = findViewById(R.id.teamsButton);
        teamsButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, TeamsActivity.class);
            startActivity(intent);
        });
    }

    public void goToStandings() {
        Button standingsButton = findViewById(R.id.standingsButton);
        standingsButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, StandingsActivity.class);
            startActivity(intent);
        });
    }

}