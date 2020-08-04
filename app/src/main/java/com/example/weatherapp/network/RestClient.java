package com.example.weatherapp.network;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.weatherapp.model.WeatherInfo;
import com.example.weatherapp.util.ExecutorServices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Query;

import static com.example.weatherapp.util.Constants.NETWORK_TIMEOUT;

public class RestClient {
    //https://weather.ls.hereapi.com/weather/1.0/report.json?apiKey=FTKrgGY6YnYj3xQyqC2mflhj2Im5uHav51VcsZI0Al0&product=observation&name=Austin-Tegel

    private static final String TAG = "RestClient";
    private static RestClient instance;
    RetrieveRunnable retrieveRunnable;
    private MutableLiveData<WeatherInfo> data;

    public static RestClient getInstance(){
        if(instance == null){
            instance = new RestClient();
        }
        return instance;
    }


    private RestClient(){
        data = new MutableLiveData<>();
    }

    public LiveData<WeatherInfo>  getWeatherInfo(){
        return data;
    }

    public void searchWeatherResults(String query,
                                 String zip,
                                 boolean observation,
                                 String key){
        if(retrieveRunnable != null){
            retrieveRunnable = null;
        }
        retrieveRunnable = new RetrieveRunnable(query,zip,observation,key);

        final Future handler = ExecutorServices.getInstance().networkIO().submit(retrieveRunnable);

        ExecutorServices.getInstance().networkIO().schedule(new Runnable() {
            @Override
            public void run() {
                // let the user know it's timed out
                handler.cancel(true);
            }
        }, NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);

    }

    private class RetrieveRunnable implements Runnable {

        String query;
        String zip;
        boolean observation;
        String key;

        public RetrieveRunnable(String query,
                                String zip,
                                boolean observation,
                                String key) {
            this.query = query;
            this.zip = zip;
            this.observation = observation;
            this.key = key;
        }

        @Override
        public void run() {
            try {
                Response response = getWeatherData(query, zip, observation, key).execute();

                if (response.code() == 200) {
                    WeatherInfo weatherInfo = (WeatherInfo) response.body();
                    data.postValue((WeatherInfo) weatherInfo);
                } else {
                    String error = response.errorBody().string();
                    data.postValue(null);
                }
            } catch (IOException e) {
                e.printStackTrace();
                data.postValue(null);
            }

        }
    }


        private Call<WeatherInfo> getWeatherData(String query,
                                                   String zip,
                                                   boolean observation,
                                                   String key ){
        return ServiceGenerator.getWeatherApi().getWeatherInfo(query,zip, observation, key );
    }
}
