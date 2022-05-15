package com.example.networking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.networking.Model.TempGame;
import com.example.networking.activities.GamesActivity;
import com.example.networking.activities.StandingsActivity;
import com.example.networking.activities.TeamsActivity;
import com.example.networking.adapters.GamesAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private BasketballViewModel viewModel;
    private ListView gameList;
    private List<String> gameListView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gameList = findViewById(R.id.gameList);
        viewModel = new ViewModelProvider(this).get(BasketballViewModel.class);
        viewModel.getSearchedTeam().observe(this, team -> {
            System.out.println(team.getName());
        });
        gameListView = new ArrayList<>();

        viewModel.getGamesByDate().observe(this, games ->{
            for(TempGame game: games)
            {
                gameListView.add(game.getTeams().getVisitor() + " " + game.getScores().getVisitors().getPoints() + " - " + game.getScores().getLocals() + " " + game.getTeams().getLocal().getName());
                // List.add(game.getTeams().getVisitor() + " " + game.getScores().getVisitors().getPoints() + " - " + game.getScores().getLocals() + " " + game.getTeams().getLocal().getName());
            }

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, gameListView);

            gameList.setAdapter(itemsAdapter);


        });

    }
    public void searchForTeam(View view)
    {
        viewModel.searchForTeam(1);
    }

    public void searchGamesByDate(View view)
    {
        viewModel.searchGamesbyDate("2022-02-12");
    }

    public void searchStandingsByConference(View view)
    {
        viewModel.searchStandingsByConference("east");
    }

}