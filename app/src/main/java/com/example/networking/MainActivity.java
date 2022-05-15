package com.example.networking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.networking.activities.GamesActivity;
import com.example.networking.activities.StandingsActivity;
import com.example.networking.activities.TeamsActivity;

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

    }
    public void searchForTeam(View view)
    {
        viewModel.searchForTeam(1);
    }
}