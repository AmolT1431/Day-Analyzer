package com.example.dayanalyser.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dayanalyser.MainActivity;
import com.example.dayanalyser.Model.Day;
import com.example.dayanalyser.R;

import java.util.ArrayList;


public class Fragment_DialogBox_details extends Fragment {


    public Fragment_DialogBox_details() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment__dialog_box_details, container, false);
    }
}