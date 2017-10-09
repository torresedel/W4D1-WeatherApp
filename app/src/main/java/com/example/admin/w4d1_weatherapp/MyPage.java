package com.example.admin.w4d1_weatherapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.admin.w4d1_weatherapp.*;

import java.util.List;

/**
 * Created by Admin on 10/9/2017.
 */

public class MyPage extends FragmentPagerAdapter {
    private List<WeatherFragment> fragments;

    public MyPage(FragmentManager fm, List<WeatherFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }
}
