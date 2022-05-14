package com.example.networking;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.networking.Model.Team;

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

    public void searchForTeam(int id)
    {
        repository.searchForTeam(id);
    }


}
