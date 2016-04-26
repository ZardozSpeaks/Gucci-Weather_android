package com.example.guest.gucciweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.example.guest.gucciweather.adapters.WeatherListAdapter;

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
    @Bind(R.id.recyclerView) ListView mRecyclerView;
    private WeatherListAdapter mAdapter;


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
                       mAdapter = new WeatherListAdapter(getApplicationContext(), mWeather);
                       mRecyclerView.setAdapter(mAdapter);
                       RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(GucciWeatherActivity.this);
                       mRecyclerView.setLayoutManager(layoutManager);
                       mRecyclerView.setHasFixedSize(true);
                   }
                });
            }
        });
    }
}
