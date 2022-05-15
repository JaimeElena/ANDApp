package com.example.networking.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.networking.Model.Games;
import com.example.networking.R;

import java.util.List;

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.GamesViewHolder>{
    List<Games> games;
    Activity activity;

    public GamesAdapter(List<Games> games, Activity activity) {
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
        holder.homeTeamName.setText("must be updated");
        holder.homeTeamScore.setText("must be updated");
        holder.awayTeamName.setText("must be updated");
        holder.awayTeamScore.setText("must be updated");
        //todo rewrite code here
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class GamesViewHolder extends RecyclerView.ViewHolder {
        private final TextView homeTeamName;
        private final TextView homeTeamScore;
        private final TextView awayTeamName;
        private final TextView awayTeamScore;
        public GamesViewHolder(@NonNull View itemView) {
            super(itemView);
            homeTeamName = itemView.findViewById(R.id.homeTeamName);
            homeTeamScore = itemView.findViewById(R.id.homeTeamScore);
            awayTeamName = itemView.findViewById(R.id.awayTeamName);
            awayTeamScore = itemView.findViewById(R.id.awayTeamScore);
        }
    }
}
