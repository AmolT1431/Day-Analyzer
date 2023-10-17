package com.example.dayanalyser.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.dayanalyser.Fragments.Fragment_DialogBox_details;
import com.example.dayanalyser.Fragments.Fragment_DialogBox_info;
import com.example.dayanalyser.Model.Day;

public class DailogBox_ViewPager_Adapter extends FragmentPagerAdapter {
String s;
String date;
Day day;

    public DailogBox_ViewPager_Adapter(@NonNull FragmentManager fm,String s,Day day) {
        super(fm);
        this.s=s;
        this.day=day;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new Fragment_DialogBox_info(s,day);
        } else {
            return new Fragment_DialogBox_details();
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0) {
            return "info";
        } else {
            return "details";

        }

    }
}
