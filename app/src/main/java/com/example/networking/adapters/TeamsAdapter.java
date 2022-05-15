package com.example.networking.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.networking.Model.Team;
import com.example.networking.R;

import java.util.ArrayList;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.ViewHolder> {
    private ArrayList<Team> teams;
    private View.OnClickListener onClickListener;

    public TeamsAdapter(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public TeamsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.team, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamsAdapter.ViewHolder holder, int position) {
        holder.name.setText(teams.get(position).getName()); // needs to be updated
        //holder.icon.setImageResource(teams.get(position).getIconId()); - commented out because of no method, should we include small pics of them also?
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView icon;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.team_name);
            icon = itemView.findViewById(R.id.team_image);
        }
    }
}
