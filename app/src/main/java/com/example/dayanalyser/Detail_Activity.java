package com.example.dayanalyser;

import static android.app.ProgressDialog.show;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.dayanalyser.Adapter.DailogBox_ViewPager_Adapter;
import com.example.dayanalyser.Model.Day;
import com.google.android.material.tabs.TabLayout;

public class Detail_Activity extends AppCompatActivity  {

    TabLayout tabLayout;
    ViewPager viewPager;
    DailogBox_ViewPager_Adapter dailogBoxViewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

       getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        tabLayout=(TabLayout) findViewById(R.id.tablayout);
        viewPager=(ViewPager) findViewById(R.id.viewpager);
        Intent intent=getIntent();
        String s=intent.getStringExtra("day_no");
        Day day=new Day();
        day=getIntent().getParcelableExtra("obj");


        dailogBoxViewPagerAdapter=new DailogBox_ViewPager_Adapter(getSupportFragmentManager(),s,day);
        viewPager.setAdapter(dailogBoxViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);



    }
}