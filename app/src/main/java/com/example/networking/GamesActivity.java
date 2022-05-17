package com.example.networking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
    private ListView gameListView;
    private List<TempGame> gameList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
        gameListView = findViewById(R.id.gameList);
        viewModel = new ViewModelProvider(this).get(BasketballViewModel.class);
        gameList = new ArrayList<>();
        date = (EditText) findViewById(R.id.date);
        viewModel.getGamesByDate().observe(this, games -> {
            for (TempGame game: games) {
                gameList.add(game);
            }
            ArrayAdapter<TempGame> itemsAdapter = new ArrayAdapter<TempGame>(this, android.R.layout.simple_list_item_1, gameList);
            gameListView.setAdapter(itemsAdapter);
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
        gameListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TempGame game = (TempGame) gameListView.getItemAtPosition(i);
                System.out.println(game);
                seeSpecificGame(game);
            }
        });
    }

    public void searchGamesByDate(View view)
    {
        viewModel.searchGamesbyDate(date.getText().toString());
        System.out.println(date.getText().toString());
    }

    public void seeSpecificGame(TempGame game) {
        Intent intent = new Intent(this, GameDetailsActivity.class);
        intent.putExtra("game", game);
        startActivity(intent);
    }
}