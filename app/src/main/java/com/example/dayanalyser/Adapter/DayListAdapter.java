package com.example.dayanalyser.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.dayanalyser.Detail_Activity;
import com.example.dayanalyser.MainActivity;
import com.example.dayanalyser.Model.Day;
import com.example.dayanalyser.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class DayListAdapter extends RecyclerView.Adapter<DayListAdapter.ViewHolder> {
    Context context;
    ArrayList<Day> days;
    Day day;

    public DayListAdapter(Context context, ArrayList<Day> days) {
        this.context = context;
        this.days = days;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.daylist__item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        day = days.get(position);
        int p=position;
        holder.daysno.setText(day.getDaynumber().toString());
        holder.date.setText(day.getDate());



        if (day.check.equals("true")) {
            holder.status.setImageResource(R.drawable.done);
        } else {
            holder.status.setImageResource(R.drawable.not_done);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Detail_Activity.class);
                String s =Integer.toString(p);
                String date=day.getDate();
                intent.putExtra("date",date);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView daysno, date;
        ImageView status;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            daysno = itemView.findViewById(R.id.daynumber);
            date = itemView.findViewById(R.id.date);
            status = itemView.findViewById(R.id.status_img);
        }

    }


}
