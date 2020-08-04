package com.example.weatherapp.network;

import com.example.weatherapp.util.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();
    private static WeatherAPI weatherApi = retrofit.create(WeatherAPI.class);

    public static WeatherAPI getWeatherApi(){
        return weatherApi;
    }
}
