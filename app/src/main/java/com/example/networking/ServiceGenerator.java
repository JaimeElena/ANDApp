package com.example.networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator
{
    private static BasketballApi basketballApi;

    public static BasketballApi getBasketballApi()
    {
        if(basketballApi == null)
        {
            basketballApi = new Retrofit.Builder()
                    .baseUrl("https://v1.basketball.api-sports.io")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(BasketballApi.class);
        }
        return basketballApi;
    }
}
