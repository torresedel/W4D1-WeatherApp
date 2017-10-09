package com.example.admin.w4d1_weatherapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.admin.w4d1_weatherapp.model.*;


public class MainActivity extends AppCompatActivity implements  WeatherFragment.OnFragmentInteractionListener{

    private static final String TAG = "MainActivityTag";
    MyPage pageAdapter;
    City myCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final java.util.List weatherFragments = new ArrayList<>();

        final retrofit2.Call<WeatherInf> callRepos
                = RetrofitHelper.createWeatherCall("w4d1");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    WeatherInf forecast = callRepos.execute().body();
                    Log.d(TAG, "run: " + forecast);
                    List<WeatherList> list = null;
                    if (forecast != null) {
                        list = forecast.getWeatherList();
                    }else
                        Log.d(TAG, "run: FORECAST NULL");
                        
                    myCity = forecast.getCity();
                    
                    List<Weather_> weathers = list.get(0).getWeather();

                    Log.d(TAG, "run: " + weathers.get(0).getDescription());


                    for (WeatherList wl: list
                            ) {
                        weatherFragments.add(WeatherFragment.newInstance(wl,myCity));
                    }
                    Log.d(TAG, "run: done");

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            pageAdapter = new MyPage(getSupportFragmentManager(), weatherFragments);
                            ViewPager pager =
                                    (ViewPager)findViewById(R.id.vpWeather);
                            pager.setAdapter(pageAdapter);
                            Log.d(TAG, "onCreate: ");
                            //pager.setAdapter(pageAdapter);
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
