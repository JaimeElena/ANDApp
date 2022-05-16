package com.example.networking.network;

import com.example.networking.network.BasketballApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator
{
    private static Retrofit.Builder  retrofitBuilder = new Retrofit.Builder()
            .baseUrl("https://api-nba-v1.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create());
    private static Retrofit retrofit = retrofitBuilder.build();

    private static BasketballApi basketballApi = retrofit.create(BasketballApi.class);

    public static BasketballApi getBasketballApi()
    {
        return basketballApi;
    }
}
