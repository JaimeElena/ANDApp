package com.example.networking.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.networking.Model.Team;
import com.example.networking.R;
import com.example.networking.adapters.TeamsAdapter;

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

        TeamsAdapter teamsAdapter = new TeamsAdapter(teams);
        recyclerView.setAdapter(teamsAdapter);
    }
}