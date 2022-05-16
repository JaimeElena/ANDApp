package com.example.networking.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.networking.Model.StandingTeam;
import com.example.networking.Model.Team;
import com.example.networking.Model.TempGame;
import com.example.networking.network.BasketballRepository;

import java.util.List;

public class BasketballViewModel extends ViewModel
{
    BasketballRepository repository;

    public BasketballViewModel()
    {
        repository = BasketballRepository.getInstance();
    }

    public LiveData<Team> getSearchedTeam()
    {
        return repository.getSearchedTeams();
    }

    public LiveData<List<TempGame>> getGamesByDate(){return  repository.getGamesByDate();}

    public LiveData<List<StandingTeam>> getStandings(){return  repository.getStandings();}

    public LiveData<List<Team>> getAllTeams(){return repository.getAllTeamsData();};


    public void searchForTeam(int id)
    {
        repository.searchForTeam(id);
    }
    public void searchGamesbyDate(String date){repository.getGamesByDate(date);}
    public void searchStandingsByConference(String conference){repository.getStandingsByConference(conference);}
    public void searchAllTeams(){repository.getAllTeamsData();}


}
