package com.example.weatherapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weatherapp.R;
import com.example.weatherapp.model.WeatherInfo;
import com.example.weatherapp.util.Constants;
import com.example.weatherapp.viewmodel.MainActivityViewModel;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel mainActivityViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView place = findViewById(R.id.place_name);
        TextView weather = findViewById(R.id.weather_info);
        TextView temp = findViewById(R.id.temperature);
        ImageView image = findViewById(R.id.imageView);
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        observer();
        mainActivityViewModel.getWeather().observe(this, new Observer<WeatherInfo>() {
            @Override
            public void onChanged(WeatherInfo weatherInfo) {
                if(weatherInfo != null){
                    place.setText(weatherInfo.getObservations().getLocation().get(0).getCity()+ " "+ weatherInfo.getObservations().getLocation().get(0).getState());
                    weather.setText(weatherInfo.getObservations().getLocation().get(0).getObservation().get(0).getDescription());
                    temp.setText(weatherInfo.getObservations().getLocation().get(0).getObservation().get(0).getTemperature());
                    Picasso.get().load(weatherInfo.getObservations().getLocation().get(0).getObservation().get(0).getIconLink()+"?apiKey="+Constants.API_KEY).into(image);
                }
            }
        });
    }

    private void observer(){
        mainActivityViewModel.searchWeather(Constants.PRODUCT, Constants.ZIP, true, Constants.API_KEY);
    }

}