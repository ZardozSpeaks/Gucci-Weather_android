package com.example.guest.gucciweather;

import java.util.ArrayList;

/**
 * Created by Guest on 4/26/16.
 */
public class WeatherForecast {
    private String mCity;
    private String mCountry;
    private double mTemp;
    private double mMinTemp;
    private double mMaxTemp;
    private ArrayList<String> mWeather = new ArrayList<>();
    private ArrayList<Integer> mWind = new ArrayList<>();

    public WeatherForecast(String city, String country, double temp,
                           double minTemp, double maxTemp,
                           ArrayList<String> weather, ArrayList<Integer> wind) {
        this.mCity = city;
        this.mCountry = country;
        this.mTemp = temp;
        this.mMinTemp = minTemp;
        this.mMaxTemp = maxTemp;
        this.mWeather = weather;
        this.mWind = wind;
    }

    public String getCity() {
        return mCity;
    }

    public String getCountry() {
        return mCountry;
    }

    public double getTemp() {
        return mTemp;
    }

    public double getMinTemp() {
        return mMinTemp;
    }

    public double getMaxTemp() {
        return mMaxTemp;
    }

    public ArrayList<String> getWeather() {
        return mWeather;
    }

    public ArrayList<Integer> getWind() {
        return mWind;
    }
}
