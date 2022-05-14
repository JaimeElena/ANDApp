package com.example.networking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity
{
    private BasketballViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(BasketballViewModel.class);
        viewModel.getSearchedTeam().observe(this, team -> {
            System.out.println(team.getName());
        });
        goToGames();
        goToTeams();
        goToStandings();
    }
    public void searchForTeam(View view)
    {
        viewModel.searchForTeam(1);
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