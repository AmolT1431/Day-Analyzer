package com.example.dayanalyser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dayanalyser.Adapter.DayListAdapter;
import com.example.dayanalyser.Adapter.Todo_List_Adapter;
import com.example.dayanalyser.DB.Mydb;
import com.example.dayanalyser.Fragments.MainActivity_Fragments.DayList_Fragment;
import com.example.dayanalyser.Fragments.MainActivity_Fragments.TodoList_Fragment;
import com.example.dayanalyser.Model.Day;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button complete_day_btn, add_day, close, todobtn, closel, set,checktudo;
    EditText tudo_edittext;
    TextView currentday, currentdate, start_day;
    RelativeLayout addinfolayout, tudolist_layout;

    RecyclerView daylis_recyclerview, tudoaddlist_recyclerview;

    public ArrayList<Day> list;
    DayListAdapter listAdapter;
    Todo_List_Adapter todoListAdapter;

    String currentdateinfo;

    Mydb mydb;
    ArrayList<String> sarrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // finding ids for layouts
        addinfolayout = (RelativeLayout) findViewById(R.id.addinfo);
        tudolist_layout = (RelativeLayout) findViewById(R.id.todo_list_add_layout);

        // finding for recycler views
        daylis_recyclerview = (RecyclerView) findViewById(R.id.daylist);
        tudoaddlist_recyclerview = (RecyclerView) findViewById(R.id.tudoaddlist);


        // finding ids text view
        currentday = (TextView) findViewById(R.id.currentday);
        currentdate = (TextView) findViewById(R.id.currentdate);
        start_day = (TextView) findViewById(R.id.day_start);

        //finding ids for button
        complete_day_btn = (Button) findViewById(R.id.daycomplet);
        close = (Button) findViewById(R.id.close);
        add_day = (Button) findViewById(R.id.adddetails);
        todobtn = (Button) findViewById(R.id.todo);
        closel = (Button) findViewById(R.id.addtudo);
        set = (Button) findViewById(R.id.set);
        checktudo=(Button)findViewById(R.id.checktodo);

        tudo_edittext = (EditText) findViewById(R.id.edittext);


        mydb = new Mydb(this);
        list = new ArrayList<>();
        sarrayList = new ArrayList<>();
        list = mydb.loaddata();

        listAdapter = new DayListAdapter(this, list);  // day list item view recycler view
        todoListAdapter = new Todo_List_Adapter(this, sarrayList);


        viewcheck();
        getedate();
        // Day list recycler view
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);
        daylis_recyclerview.setLayoutManager(linearLayoutManager);
        daylis_recyclerview.scrollToPosition(list.size() - 1);
        daylis_recyclerview.setAdapter(listAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        tudoaddlist_recyclerview.setLayoutManager(layoutManager);
        tudoaddlist_recyclerview.setAdapter(todoListAdapter);


        loadfragment(new DayList_Fragment(MainActivity.this, list), 0);


        //setting click lister to buttons
        complete_day_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadfragment(new DayList_Fragment(MainActivity.this, list), 1);
                addinfolayout.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
                addinfolayout.getLayoutParams().width = LinearLayout.LayoutParams.MATCH_PARENT;
                addinfolayout.requestLayout();
                complete_day_btn.setVisibility(View.GONE);


                currentdate.setText(currentdateinfo);
                currentday.setText(Integer.toString(list.size() + 1));


            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addinfolayout.getLayoutParams().height = 0;
                addinfolayout.getLayoutParams().width = 0;
                addinfolayout.requestLayout();
                complete_day_btn.setVisibility(View.VISIBLE);


            }
        });

        add_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addinfolayout.getLayoutParams().height = 0;
                addinfolayout.getLayoutParams().width = 0;
                addinfolayout.requestLayout();
                complete_day_btn.setVisibility(View.VISIBLE);


                Toast.makeText(MainActivity.this, "Your Day is Added", Toast.LENGTH_SHORT).show();

                Day f = new Day(list.size() + 1, currentdateinfo, "true");
                mydb.addrecord(currentdateinfo, "true");

                list.add(f);

                daylis_recyclerview.scrollToPosition(list.size() - 1);
                listAdapter.notifyDataSetChanged();
                viewcheck();
                loadfragment(new DayList_Fragment(MainActivity.this, list), 1);

            }
        });
        todobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // loadfragment(new TodoList_Fragment(),1);
                tudolist_layout.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
                tudolist_layout.getLayoutParams().height = 650;
                tudolist_layout.requestLayout();

            }
        });
        checktudo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadfragment(new TodoList_Fragment(), 1);
            }
        });


        closel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tudolist_layout.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
                tudolist_layout.getLayoutParams().height = 0;
                tudolist_layout.requestLayout();
                Toast.makeText(MainActivity.this, "Your Tudo is Added", Toast.LENGTH_SHORT).show();
                sarrayList.clear();

            }
        });

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st = tudo_edittext.getText().toString();
                sarrayList.add(st);
                todoListAdapter.notifyDataSetChanged();
                tudo_edittext.setText("");

            }
        });
    }


    public void getedate() {
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd,MMMM,yyyy");
        currentdateinfo = s.format(date).replace(",", "/");
    }

    public void viewcheck() {
        if (list.isEmpty()) {
            start_day.setVisibility(View.VISIBLE);
        } else {
            start_day.setVisibility(View.GONE);
        }
    }

    public void loadfragment(Fragment fragment, int flag) {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (flag == 0)
            ft.add(R.id.container, fragment);
        else
            ft.replace(R.id.container, fragment);
        ft.commit();
    }



}