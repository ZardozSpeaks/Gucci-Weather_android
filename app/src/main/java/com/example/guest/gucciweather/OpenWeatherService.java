package com.example.guest.gucciweather;


import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OpenWeatherService {

    public static void findWeather(String location, Callback callback) {
        String OPEN_WEATHER_KEY = Constants.OPEN_WEATHER_KEY;

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.OPEN_WEATHER_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.OPEN_WEATHER_APPID_QUERY_PARAMETER, location);
        urlBuilder.addQueryParameter(Constants.OPEN_WEATHER_DAYS, "7");
        urlBuilder.addQueryParameter("appid", OPEN_WEATHER_KEY);
        String url = urlBuilder.build().toString();

        Log.d("url", url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<WeatherForecast> processResults(Response response) {
        ArrayList<WeatherForecast> weatherForecast = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if(response.isSuccessful()) {
                JSONObject weatherJSON = new JSONObject(jsonData);
                JSONArray forecastsJSON = weatherJSON.getJSONArray("forecasts");
                for (int i = 0; i < forecastsJSON.length(); i++) {
                    JSONObject forcastJSON = forecastsJSON.getJSONObject(i);
                    String city = forcastJSON.getJSONObject("city").getString("name");
                    String country = forcastJSON.getJSONObject("city").getString("country");
                    Double temp = forcastJSON.getJSONObject("main").getDouble("temp");
                    Double maxTemp = forcastJSON.getJSONObject("main").getDouble("temp_max");
                    Double minTemp = forcastJSON.getJSONObject("main").getDouble("temp_min");
                    String weather = forcastJSON.getJSONObject("weather").getString("description");
                    String wind = forcastJSON.getJSONObject("wind").getString("speed");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return weatherForecast;
    }
}
