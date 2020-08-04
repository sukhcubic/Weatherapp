package com.example.weatherapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.weatherapp.model.WeatherInfo;
import com.example.weatherapp.repository.WeatherRepository;

public class MainActivityViewModel extends ViewModel {

    private WeatherRepository weatherRepository;


    public MainActivityViewModel() {
        weatherRepository = WeatherRepository.getInstance();
    }

    public LiveData<WeatherInfo> getWeather(){
        return weatherRepository.getWeatherInfo();
    }

    public void searchWeather(String query,
                              String zip,
                              boolean observation,
                              String key){
        weatherRepository.searchWeatherApi(query, zip, observation,key);

    }
}
