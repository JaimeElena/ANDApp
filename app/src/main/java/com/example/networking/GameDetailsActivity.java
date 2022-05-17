package com.example.networking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.networking.Model.TempGame;
import com.example.networking.ViewModel.BasketballViewModel;

public class GameDetailsActivity extends AppCompatActivity {

    private BasketballViewModel viewModel;
    private TextView localTeamNameTv;
    private TextView localTeamScoreTv;
    private TextView awayTeamNameTv;
    private TextView awayTeamScoreTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_details);
        localTeamNameTv = findViewById(R.id.localTeamName);
        localTeamScoreTv = findViewById(R.id.localTeamScore);
        awayTeamNameTv = findViewById(R.id.visitorTeamName);
        awayTeamScoreTv = findViewById(R.id.visitorTeamScore);
        Intent intent = getIntent();
        TempGame game = (TempGame) intent.getSerializableExtra("game");
        localTeamNameTv.setText(game.getTeams().getLocal().getName());
        localTeamScoreTv.setText(game.getScores().getLocals().getPoints());
        awayTeamNameTv.setText(game.getTeams().getVisitor().getName());
        awayTeamScoreTv.setText(game.getScores().getVisitors().getPoints());
    }
}