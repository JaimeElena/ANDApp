package com.example.networking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.networking.Model.Team;

import java.util.ArrayList;

public class TeamsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hasFixedSize();
        ArrayList<Team> teams = new ArrayList<>();
        teams.add(new Team(0, "blah blah", "nickname", "1738", "idk", "horsens", "8700"));
        teams.add(new Team(1, "idk", "nickname", "1738", "idk", "horsens", "8700"));
        teams.add(new Team(2, "lol", "nickname", "1738", "idk", "horsens", "8700"));
        teams.add(new Team(3, "haha", "nickname", "1738", "idk", "horsens", "8700"));
        teams.add(new Team(4, "wtf", "nickname", "1738", "idk", "horsens", "8700"));
        TeamsAdapter teamsAdapter = new TeamsAdapter(teams);
        recyclerView.setAdapter(teamsAdapter);
    }
}