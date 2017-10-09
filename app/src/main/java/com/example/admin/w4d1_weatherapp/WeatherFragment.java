package com.example.admin.w4d1_weatherapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.w4d1_weatherapp.model.WeatherList;
import com.example.admin.w4d1_weatherapp.model.City;


public class WeatherFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_WEATHER_LIST = "weatherlist";
    private static final String ARG_WEATHER_CITY = "weathercity";
    TextView tvWeatherType;
    TextView tvCity;
    ImageView ivWeather;

    private OnFragmentInteractionListener mListener;
    private String weatherType;
    private String city;

    public WeatherFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static WeatherFragment newInstance(WeatherList weatherList, City myCity) {

        WeatherFragment fragment = new WeatherFragment();
        Bundle args = new Bundle();
        args.putString(ARG_WEATHER_LIST, weatherList.getWeather().get(0).getDescription());
        args.putString(ARG_WEATHER_CITY, myCity.getName());
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            weatherType = getArguments().getString(ARG_WEATHER_LIST);
            city = getArguments().getString(ARG_WEATHER_CITY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_screen_slide, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        tvWeatherType = view.findViewById(R.id.tvWeatherType);
        tvCity = view.findViewById(R.id.tvCity);
        ivWeather = view.findViewById(R.id.imageView);

        String choice = weatherType;
        if(choice != null){
            tvWeatherType.setText(choice);
            tvCity.setText(city);
            if(choice.compareTo("clear sky") == 0){
                ivWeather.setImageDrawable(getResources().getDrawable(R.drawable.clear));
            }else if(choice.compareTo("few clouds") == 0){
                ivWeather.setImageDrawable(getResources().getDrawable(R.drawable.cloudy));
            }else if(choice.compareTo("light rain") == 0){
                ivWeather.setImageDrawable(getResources().getDrawable(R.drawable.rain));
            }else if(choice.compareTo("moderate rain") == 0){
                ivWeather.setImageDrawable(getResources().getDrawable(R.drawable.hardrain));
            }else if(choice.compareTo("scattered clouds") == 0){
                ivWeather.setImageDrawable(getResources().getDrawable(R.drawable.scattered));
            }else if(choice.compareTo("thunderstorm") == 0){
                ivWeather.setImageDrawable(getResources().getDrawable(R.drawable.thunder));
            }else if(choice.compareTo("mist") == 0){
                ivWeather.setImageDrawable(getResources().getDrawable(R.drawable.mist));
            }else if(choice.compareTo("snow") == 0){
                ivWeather.setImageDrawable(getResources().getDrawable(R.drawable.snow));
            }
        }
        super.onViewCreated(view, savedInstanceState);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
