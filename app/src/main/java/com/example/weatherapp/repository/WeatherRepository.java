package com.example.weatherapp.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

import com.example.weatherapp.model.WeatherInfo;
import com.example.weatherapp.network.RestClient;

import java.util.List;

public class WeatherRepository {
    private static WeatherRepository instance;
    private RestClient apiClient;

    //private MediatorLiveData<WeatherInfo> wData = new MediatorLiveData<>();

    public static WeatherRepository getInstance(){
        if(instance == null){
            instance = new WeatherRepository();
        }
        return instance;
    }

    private WeatherRepository(){
        apiClient = RestClient.getInstance();
    //    init();
    }

//    private void init() {
//        LiveData<WeatherInfo> liveData = apiClient.getWeatherInfo();
//        wData.addSource(liveData, new Observer<WeatherInfo>() {
//            @Override
//            public void onChanged(WeatherInfo weatherInfo) {
//                if(weatherInfo != null){
//                    wData.setValue(weatherInfo);
//                }else{
//                    //error handeling
//                }
//            }
//        });
//    }

    public void searchWeatherApi(String query,
                                 String zip,
                                 boolean observation,
                                 String key){
        apiClient.searchWeatherResults(query, zip, observation, key);
    }

    public LiveData<WeatherInfo> getWeatherInfo(){
        return apiClient.getWeatherInfo();
    }
}
