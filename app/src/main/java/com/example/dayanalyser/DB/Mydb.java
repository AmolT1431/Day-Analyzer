package com.example.dayanalyser.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.dayanalyser.Model.Day;

import java.util.ArrayList;

public class Mydb extends SQLiteOpenHelper {
    private static final String dbname = "days_info";

    public Mydb(@Nullable Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry = "create table day ( id integer primary key autoincrement, date text, status text)";
        sqLiteDatabase.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String qry = "DROP TABLE IF EXISTS day";
        sqLiteDatabase.execSQL(qry);
        onCreate(sqLiteDatabase);
    }

    public String addrecord(String name, String contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("date", name);
        cv.put("status", contact);


        float res = db.insert("day", null, cv);

        if (res == -1)
            return "Failed";
        else
            return "Successfully inserted";

    }


    public ArrayList<Day> loaddata() {
        SQLiteDatabase database = this.getReadableDatabase();
        String lqur = "select * from Day";
        Cursor c = database.rawQuery(lqur, null);
        ArrayList<Day> arrayList = new ArrayList<>();
        while (c.moveToNext()) {
            Day day = new Day();
            day.daynumber = c.getInt(0);
            day.date = c.getString(1);
            day.check = c.getString(2);

            arrayList.add(day);
        }

        return arrayList;
    }
}
