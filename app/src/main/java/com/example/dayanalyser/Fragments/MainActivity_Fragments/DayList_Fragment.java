package com.example.dayanalyser.Fragments.MainActivity_Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dayanalyser.Adapter.DayListAdapter;
import com.example.dayanalyser.Model.Day;
import com.example.dayanalyser.R;

import java.util.ArrayList;


public class DayList_Fragment extends Fragment {
    Context context;
    ArrayList<Day> arrayList;
    RecyclerView recyclerView;

    public DayList_Fragment(Context context, ArrayList<Day> arrayList) {
        this.context = context;
        this.arrayList = arrayList;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_day_list_, container, false);
        recyclerView = view.findViewById(R.id.list);
        DayListAdapter listAdapter = new DayListAdapter(context, arrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.scrollToPosition(arrayList.size() - 1);
        recyclerView.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();


        return view;
    }
}