package com.example.dayanalyser.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dayanalyser.R;

import java.util.ArrayList;

public class Todo_List_Adapter extends RecyclerView.Adapter<Todo_List_Adapter.ViewHolder> {

    ArrayList<String> items;
    Context context;
    public Todo_List_Adapter(Context context,ArrayList<String> arrayList) {
        this.context=context;
        this.items=arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.todo_list_item_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String s=items.get(position);
        holder.textView.setText(s);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tod_item_name);
        }
    }
}
