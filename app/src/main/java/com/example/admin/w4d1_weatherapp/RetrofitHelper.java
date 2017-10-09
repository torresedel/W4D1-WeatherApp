package com.example.admin.w4d1_weatherapp;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

import com.example.admin.w4d1_weatherapp.model.*;

/**
 * Created by Admin on 10/9/2017.
 */

public class RetrofitHelper {
    private static final String BASE_URL = "http://samples.openweathermap.org";

    public static Retrofit create(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return  retrofit;

    }

    public static Call<WeatherInf> createWeatherCall(String city){
        Retrofit retrofit = create();
        ApiService apiService = retrofit.create(ApiService.class);

        return apiService.getWeatherForecast();

    }

    //REST api's interface
    interface ApiService{

        @GET("/data/2.5/forecast?q=georgia,us&appid=ea76baa284f4be9a2ab67e37e78619d0")
        Call<WeatherInf> getWeatherForecast();

    }

}