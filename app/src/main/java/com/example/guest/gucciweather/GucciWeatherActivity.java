package com.example.guest.gucciweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class GucciWeatherActivity extends AppCompatActivity {
    public ArrayList<WeatherForecast> mWeather = new ArrayList<>();
    public static final String TAG = GucciWeatherActivity.class.getSimpleName();
    @Bind(R.id.gucciWeatherListView) ListView mGucciListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gucci_weather);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        getWeather(location);
    }

    private void getWeather(String location) {
        final OpenWeatherService openWeatherService = new OpenWeatherService();

        OpenWeatherService.findWeather(location, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mWeather = openWeatherService.processResults(response);

                GucciWeatherActivity.this.runOnUiThread(new Runnable() {
                   @Override
                   public void run() {

                       String[] weatherForecasts = new String[mWeather.size()];
                       for (int i = 0; i < weatherForecasts.length; i++) {
                           weatherForecasts[i] = mWeather.get(i).getCity();
                           ArrayAdapter adapter = new ArrayAdapter(GucciWeatherActivity.this,
                                   android.R.layout.simple_list_item_1, weatherForecasts);
                           mGucciListView.setAdapter(adapter);

                           for (WeatherForecast weatherForecast : mWeather) {
                               Log.d(TAG, "City: " + weatherForecast.getCity());
                               Log.d(TAG, "Country: " + weatherForecast.getCountry());
                               Log.d(TAG, "Temperature: " + weatherForecast.getTemp());
                           }
                       }
                   }
                });
            }
        });

    }
}
