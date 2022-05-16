package com.example.networking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

import com.example.networking.ViewModel.BasketballViewModel;
import com.example.networking.Model.TempGame;
import com.example.networking.adapters.GamesAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class GamesActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    EditText date;
    DatePickerDialog datePickerDialog;
    Button button;
    BasketballViewModel viewModel;
    GamesAdapter gamesAdapter;
    private ListView gameList;
    private List<String> gameListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
        gameList = findViewById(R.id.gameList);
        viewModel = new ViewModelProvider(this).get(BasketballViewModel.class);
        gameListView = new ArrayList<>();
        date = (EditText) findViewById(R.id.date);
        viewModel.getGamesByDate().observe(this, games -> {
            for (TempGame game: games) {
                gameListView.add(game.getTeams().getVisitor() + " " + game.getScores().getVisitors().getPoints() + " - " + game.getScores().getLocals().getPoints() + " " + game.getTeams().getLocal().getName());
            }
            ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, gameListView);
            gameList.setAdapter(itemsAdapter);
        });
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
    }

    public void searchGamesByDate(View view)
    {
        viewModel.searchGamesbyDate("2022-02-12");
    }
}