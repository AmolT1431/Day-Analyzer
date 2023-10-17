package com.example.dayanalyser.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dayanalyser.DB.Mydb;
import com.example.dayanalyser.MainActivity;
import com.example.dayanalyser.Model.Day;
import com.example.dayanalyser.R;

import java.util.ArrayList;


public class Fragment_DialogBox_info extends Fragment {
    TextView day,date;
    ArrayList<Day> dayArrayList;
    String s;
    Day daydata;

    public Fragment_DialogBox_info(String s,Day daydata) {
        this.s=s;
        this.daydata=daydata;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment__dialog_box_info, container, false);
        day=view.findViewById(R.id.dyano);
        date=view.findViewById(R.id.daydate);
      //  date.setText(daydata.getDate());
        day.setText(s);
        return view;
    }

}