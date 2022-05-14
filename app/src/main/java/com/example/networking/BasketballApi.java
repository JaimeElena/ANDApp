package com.example.networking;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BasketballApi
{
    @Headers("X-RapidAPI-Key:60131dd484msh975ffe9dd37a1adp1ba8c6jsn5d0458e78868")
    @GET("api-nba-v1.p.rapidapi.com/teams/")
    Call<TeamResponse> getTeam(@Query("id")  int teamId);

}
