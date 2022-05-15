package com.example.networking;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.networking.Model.StandingTeam;
import com.example.networking.Model.Team;
import com.example.networking.Model.TempGame;

import java.util.List;

public class BasketballViewModel extends ViewModel
{
    BasketballRepository repository;

    public BasketballViewModel()
    {
        repository = BasketballRepository.getInstance();
    }

    LiveData<Team> getSearchedTeam()
    {
        return repository.getSearchedTeams();
    }

    LiveData<List<TempGame>> getGamesByDate(){return  repository.getGamesByDate();}

    LiveData<List<StandingTeam>> getStandings(){return  repository.getStandings();}


    public void searchForTeam(int id)
    {
        repository.searchForTeam(id);
    }
    public void searchGamesbyDate(String date){repository.getGamesByDate(date);}
    public void searchStandingsByConference(String conference){repository.getStandingsByConference(conference);}


}
