package com.example.dayanalyser.Fragments.MainActivity_Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dayanalyser.R;


public class TodoList_Fragment extends Fragment {


    public TodoList_Fragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_todo_list_, container, false);
        return view;
    }
}