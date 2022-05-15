package com.example.networking.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.networking.BasketballViewModel;
import com.example.networking.Model.Games;
import com.example.networking.Model.TempGame;
import com.example.networking.R;
import com.example.networking.adapters.GamesAdapter;

import java.util.Calendar;
import java.util.List;

public class GamesActivity extends AppCompatActivity {
    List<TempGame> games;
    RecyclerView recyclerView;
    EditText date;
    DatePickerDialog datePickerDialog;
    Button button;
    BasketballViewModel viewModel;
    GamesAdapter gamesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
        viewModel = new ViewModelProvider(this).get(BasketballViewModel.class);
        recyclerView = findViewById(R.id.games_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hasFixedSize();
        gamesAdapter = new GamesAdapter(games, this);
        recyclerView.setAdapter(gamesAdapter);
        date = (EditText) findViewById(R.id.date);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(GamesActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        date.setText(year + "-" + "0" + (monthOfYear + 1 ) + "-" + dayOfMonth);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        button = findViewById(R.id.search_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.searchGamesbyDate("2022-02-12");
                searchGamesByDate();
                // todo method that gets the games for this date and refreshes it, use fragment maybe?
            }
        });
    }

    public void searchGamesByDate()
    {
        viewModel.getGamesByDate().observe(this, games ->{
            for(TempGame game: games)
            {
                games.add(game);
                System.out.println(game.getId() + " " + game.getLeague());
                // games.add(game.getTeams().getVisitor() + " " + game.getScores().getVisitors().getPoints() + " - " + game.getScores().getLocals() + " " + game.getTeams().getLocal().getName());
            }
        });
    }
}