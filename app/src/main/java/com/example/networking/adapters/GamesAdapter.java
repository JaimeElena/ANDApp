package com.example.networking.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.networking.Model.TempGame;
import com.example.networking.R;

import java.util.List;

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.GamesViewHolder>{
    List<TempGame> games;
    Activity activity;

    public GamesAdapter(List<TempGame> games, Activity activity) {
        this.games = games;
        this.activity = activity;
    }
    @NonNull
    @Override
    public GamesAdapter.GamesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate((R.layout.activity_games), parent, false);
        return new GamesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GamesAdapter.GamesViewHolder holder, int position) {
        //todo rewrite code here
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class GamesViewHolder extends RecyclerView.ViewHolder {
        public GamesViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
