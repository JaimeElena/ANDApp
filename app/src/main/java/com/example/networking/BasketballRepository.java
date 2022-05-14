package com.example.networking;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.networking.Model.Team;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class BasketballRepository
{
    private static BasketballRepository instance;
    private final MutableLiveData<Team> searchedTeam;

    private BasketballRepository()
    {
        searchedTeam = new MutableLiveData<Team>();
    }

    public static  synchronized BasketballRepository getInstance()
    {
        if(instance == null)
        {
            instance = new BasketballRepository();
        }
        return instance;
    }

    public LiveData<Team> getSearchedTeams()
    {
        return searchedTeam;
    }

    public void searchForTeam(int teamId) {
        BasketballApi basketballApi = ServiceGenerator.getBasketballApi();
        Call<TeamResponse> call = basketballApi.getTeam(teamId);
        call.enqueue(new Callback<TeamResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                if (response.isSuccessful()) {
                    searchedTeam.setValue(response.body().getTeam());
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<TeamResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }
}
