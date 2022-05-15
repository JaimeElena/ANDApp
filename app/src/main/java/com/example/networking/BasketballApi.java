package com.example.networking;

import com.example.networking.Model.GameResponseClass;
import com.example.networking.Model.ResponseClass;

import java.util.Date;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

import retrofit2.http.Query;

public interface BasketballApi
{
    @Headers("X-RapidAPI-Key: 60131dd484msh975ffe9dd37a1adp1ba8c6jsn5d0458e78868")
    @GET("teams")
    Call<ResponseClass> getTeam(@Query("id")  int id);

    @Headers("X-RapidAPI-Key: 60131dd484msh975ffe9dd37a1adp1ba8c6jsn5d0458e78868")
    @GET("teams")
    Call<ResponseClass> getAllTeams();

    @Headers("X-RapidAPI-Key: 60131dd484msh975ffe9dd37a1adp1ba8c6jsn5d0458e78868")
    @GET("games")
    Call<GameResponseClass> getGamesByDate(@Query("date") String date);

}
