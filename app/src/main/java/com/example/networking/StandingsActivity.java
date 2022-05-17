package com.example.networking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.networking.Model.StandingTeam;
import com.example.networking.R;
import com.example.networking.ViewModel.BasketballViewModel;

import java.util.ArrayList;
import java.util.List;

public class StandingsActivity extends AppCompatActivity {

    private BasketballViewModel viewModel;
    private ListView standingsListView;
    private List<String> standingsList;
    private LinearLayout linearLayout;
    private TextView standingsTeamName;
    private TextView standingsTeamRank;
    private TextView standingsTeamWins;
    private TextView standingsTeamLoss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standings);
        standingsListView = findViewById(R.id.standingsList);
        linearLayout = findViewById(R.id.tableRowStandings);
        viewModel = new ViewModelProvider(this).get(BasketballViewModel.class);
        standingsList = new ArrayList<>();
        viewModel.getStandings().observe(this, standings -> {
            for (StandingTeam standing: standings) {
                standingsList.add(standing.toString());
            }
            ArrayAdapter<String> standingsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, standingsList);
            standingsListView.setAdapter(standingsAdapter); //todo fix null pointer
        });
        viewModel.searchStandingsByConference("west");
        //standingsTeamName = (TextView) getLayoutInflater().inflate(R.layout.table_list_standings, null);
        //linearLayout.addView(standingsTeamName);
    }
}