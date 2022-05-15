package com.example.networking.adapters;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.networking.Model.Standings;
import com.example.networking.Model.Team;
import com.example.networking.R;

import java.util.List;

public class StandingsAdapter extends RecyclerView.Adapter<StandingsAdapter.StandingsViewHolder> {
    List<Standings> standings;
    Activity activity;

    public StandingsAdapter(List<Standings> standings, Activity activity) {
        this.standings = standings;
        this.activity = activity;
    }

    @NonNull
    @Override
    public StandingsAdapter.StandingsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.table_list_standings, parent, false);
        return new StandingsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StandingsAdapter.StandingsViewHolder holder, int position) {
        int rowPos = holder.getAbsoluteAdapterPosition();
        if (rowPos == 0) {
            holder.tableRowStandings.setBackgroundResource(R.color.purple_200);
            TextView tv;
            for (int i = 0; i < holder.tableRowStandings.getChildCount(); i++) {
                View view = holder.tableRowStandings.getChildAt(i);
                if (view instanceof TextView) {
                    tv = (TextView) view;
                    tv.setTextColor(view.getContext().getResources().getColor(R.color.white));
                    tv.setTypeface(null, Typeface.BOLD);
                }
            }
        } else {
            Standings st = standings.get(rowPos - 1);
            holder.tableRowStandings.setBackgroundResource(0);
           // Team team = new Team().getTeamById(st.getTeamId(), activity); // fix this
           // String rankAndTeam = st.getConfRank() + "- " + team.getNickname();
           // holder.tvStandingsName.setText(rankAndTeam);
            holder.tvStandingsWin.setText(st.getWin());
            holder.tvStandingsLosses.setText(st.getLoss());
            holder.tvStandingsPct.setText(st.getWinPct());
            holder.tvStandingsStreak.setText(st.getStreak());
            String lastTen = st.getLastTenWin() + "-" + st.getLastTenLoss();
            holder.tvStandingsLastTen.setText(lastTen);
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class StandingsViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvStandingsName;
        private final TextView tvStandingsWin;
        private final TextView tvStandingsLosses;
        private final TextView tvStandingsPct;
        private final TextView tvStandingsStreak;
        private final TextView tvStandingsLastTen;
        private final LinearLayout tableRowStandings;
        public StandingsViewHolder(@NonNull View itemView) {
            super(itemView);
            tvStandingsName = itemView.findViewById(R.id.tvStandingsName);
            tvStandingsWin = itemView.findViewById(R.id.tvStandingsWin);
            tvStandingsLosses = itemView.findViewById(R.id.tvStandingsLosses);
            tvStandingsPct = itemView.findViewById(R.id.tvStandingsPct);
            tvStandingsStreak = itemView.findViewById(R.id.tvStandingsStreak);
            tvStandingsLastTen = itemView.findViewById(R.id.tvStandingsLastTen);
            tableRowStandings = itemView.findViewById(R.id.tableRowStandings);
        }
    }
}
