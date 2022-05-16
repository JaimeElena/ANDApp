package com.example.networking.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.networking.ViewModel.BasketballViewModel;
import com.example.networking.R;

import java.util.ArrayList;
import java.util.List;

public class StandingsActivity extends AppCompatActivity {

    private BasketballViewModel viewModel;
    private ListView standingsListView;
    private List<String> standingsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standings);
        standingsListView = findViewById(R.id.standingsList);
        viewModel = new ViewModelProvider(this).get(BasketballViewModel.class);
        standingsList = new ArrayList<>();
        ArrayAdapter<String> standingsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, standingsList);
        standingsListView.setAdapter(standingsAdapter); //todo fix null pointer
    }
}