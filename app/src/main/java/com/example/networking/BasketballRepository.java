package com.example.networking;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.networking.Model.GameResponseClass;
import com.example.networking.Model.ResponseClass;
import com.example.networking.Model.StandingTeam;
import com.example.networking.Model.StandingsResponseClass;
import com.example.networking.Model.Team;
import com.example.networking.Model.TempGame;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;


public class BasketballRepository
{
    private static BasketballRepository instance;
    private final MutableLiveData<Team> searchedTeam;
    private final MutableLiveData<List<TempGame>> gamesByDate;
    private final MutableLiveData<List<Team>> allTeams;
    private final MutableLiveData<List<StandingTeam>> standings;

    private BasketballRepository()
    {
        searchedTeam = new MutableLiveData<Team>();
        gamesByDate = new MutableLiveData<List<TempGame>>();
        allTeams = new MutableLiveData<List<Team>>();
        standings = new MutableLiveData<>();
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

    public MutableLiveData<List<TempGame>> getGamesByDate() {
        return gamesByDate;
    }

    public MutableLiveData<Team> getSearchedTeam() {
        return searchedTeam;
    }

    public MutableLiveData<List<StandingTeam>> getStandings() {
        return standings;
    }

    public void searchForTeam(int teamId) {
        BasketballApi basketballApi = ServiceGenerator.getBasketballApi();
        Call<ResponseClass> call = basketballApi.getTeam(teamId);
        call.enqueue(new Callback<ResponseClass>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<ResponseClass> call, Response<ResponseClass> response) {
                if (response.isSuccessful()) {
                    searchedTeam.setValue(response.body().getResponse().get(0));
                    Log.i("Header", response.headers().toString());
                    Log.i("Complete response", String.valueOf(response.code()));
                    Log.i("Success", response.body().toString());
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<ResponseClass> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :( " + t.getMessage());

            }
        });
    }

        public void getGamesByDate(String date){
            BasketballApi basketballApi = ServiceGenerator.getBasketballApi();
            Call<GameResponseClass> call = basketballApi.getGamesByDate(date);
            call.enqueue(new Callback<GameResponseClass>() {
                @EverythingIsNonNull
                @Override
                public void onResponse(Call<GameResponseClass> call, Response<GameResponseClass> response) {
                    if (response.isSuccessful()) {
                        gamesByDate.setValue(response.body().getGameList());
                        Log.i("Header", response.headers().toString());
                        Log.i("Complete response", String.valueOf(response.code()));
                        Log.i("Success", response.body().getGameList().toString());
                    }
                }

                @EverythingIsNonNull
                @Override
                public void onFailure(Call<GameResponseClass> call, Throwable t) {
                    Log.i("Retrofit", "Something went wrong :( " + t.getMessage());

                }
            });
        }

    public void getAllTeams(){
        BasketballApi basketballApi = ServiceGenerator.getBasketballApi();
        Call<ResponseClass> call = basketballApi.getAllTeams();
        call.enqueue(new Callback<ResponseClass>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<ResponseClass> call, Response<ResponseClass> response) {
                if (response.isSuccessful()) {
                    allTeams.setValue(response.body().getResponse());
                    Log.i("Header", response.headers().toString());
                    Log.i("Complete response", String.valueOf(response.code()));
                    Log.i("Success", response.body().getResponse().toString());
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<ResponseClass> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :( " + t.getMessage());

            }
        });
    }

    public void getStandingsByConference(String conference)
    {
        BasketballApi basketballApi = ServiceGenerator.getBasketballApi();
        Call<StandingsResponseClass> call = basketballApi.getStandingsByConference(conference, "standard", "2021");
        call.enqueue(new Callback<StandingsResponseClass>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<StandingsResponseClass> call, Response<StandingsResponseClass> response) {
                if (response.isSuccessful()) {
                    standings.setValue(response.body().getResponse());
                    Log.i("Header", response.headers().toString());
                    Log.i("Complete response", String.valueOf(response.code()));
                    Log.i("Success", response.body().getResponse().toString());
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<StandingsResponseClass> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :( " + t.getMessage());

            }
        });
    }
    }

