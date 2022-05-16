package com.example.networking.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.networking.Model.Team;
import com.example.networking.R;
import com.example.networking.ViewModel.BasketballViewModel;
import com.example.networking.adapters.TeamsAdapter;

import java.util.ArrayList;
import java.util.List;

public class TeamsActivity extends AppCompatActivity {
    private BasketballViewModel viewModel;
    private ListView teamsListView;
    private List<String> teamsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);
        teamsListView = findViewById(R.id.teamsList);
        viewModel = new ViewModelProvider(this).get(BasketballViewModel.class);
        teamsList = new ArrayList<>();
        viewModel.getAllTeams().observe(this, teams -> {
            for (Team team: teams) {
                teamsList.add(team.getName());
            }
            ArrayAdapter<String> teamsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, teamsList);
            teamsListView.setAdapter(teamsAdapter); //todo fix null pointer
        });
        viewModel.searchAllTeams();
    }
}