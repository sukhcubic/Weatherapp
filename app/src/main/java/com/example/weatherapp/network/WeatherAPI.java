package com.example.weatherapp.network;
import com.example.weatherapp.model.WeatherInfo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPI {
    //Weather API using Retrofit
    @GET("/weather/1.0/report.json")
    Call<WeatherInfo> getWeatherInfo(
            @Query("product") String query,
            @Query("zipcode") String zip,
            @Query("oneobservation") boolean oneobservation,
            @Query("apiKey") String key );
}
