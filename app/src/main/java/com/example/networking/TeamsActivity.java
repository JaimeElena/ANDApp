package com.example.networking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.networking.Model.Team;
import com.example.networking.ViewModel.BasketballViewModel;

import java.util.ArrayList;
import java.util.List;

public class TeamsActivity extends AppCompatActivity {
    private Team team1213123;
    private BasketballViewModel viewModel;
    private ListView teamsListView;
    private List<Team> teamsList;
    private int teamId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);
        teamsListView = findViewById(R.id.teamsList);
        viewModel = new ViewModelProvider(this).get(BasketballViewModel.class);
        teamsList = new ArrayList<>();
        viewModel.getAllTeams().observe(this, teams -> {
            for (Team team: teams) {
                teamsList.add(team);
            }
            ArrayAdapter<Team> teamsAdapter = new ArrayAdapter<Team>(this, android.R.layout.simple_list_item_1, teamsList);
            teamsListView.setAdapter(teamsAdapter);
            teamsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Team team = (Team) teamsListView.getItemAtPosition(i);
                    System.out.println(teamsListView.getItemAtPosition(i));
                    //teamId = team.getId();
                    //System.out.println(teamId);
                    seeSpecificTeam(team);
                }
            });
        });
        viewModel.searchAllTeams();
    }

    public void seeSpecificTeam(Team team) {
        Intent intent = new Intent(this, TeamDetailsActivity.class);
        intent.putExtra("team", team);
        startActivity(intent);
    }


}