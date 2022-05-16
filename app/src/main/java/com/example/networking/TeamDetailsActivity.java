package com.example.networking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.networking.Model.Team;
import com.example.networking.R;
import com.example.networking.ViewModel.BasketballViewModel;

public class TeamDetailsActivity extends AppCompatActivity {
    private BasketballViewModel viewModel;
    private int teamId;
    private String teamName;
    private String arenaName;
    private String teamNickname;
    private TextView teamNameTv;
    private TextView arenaNameTv;
    private TextView teamNicknameTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_details);
        teamNameTv = findViewById(R.id.team_name);
        arenaNameTv = findViewById(R.id.arena_name);
        teamNicknameTv = findViewById(R.id.team_nickname);
        Bundle data = getIntent().getExtras();
        Intent intent = getIntent();
        Team team = (Team) intent.getSerializableExtra("team");
        System.out.println(team);
        // System.out.println(teamId);
        /*viewModel.getSearchedTeam().observe(this, teams -> {
            teamName = teams.getName();
            arenaName = teams.getCity();
            teamNickname = teams.getNickname();
        });*/
        //viewModel.searchForTeam(teamId);
        teamNameTv.setText(team.getName());
        arenaNameTv.setText(team.getCity());
        teamNicknameTv.setText(team.getNickname());
    }

    public void searchTeamById(View view) {
        viewModel.searchForTeam(teamId);
    }

}