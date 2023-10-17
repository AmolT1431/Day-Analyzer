package com.example.dayanalyser.Model;

public class Day {
    public Integer daynumber;
    public String date;
    public String check;


    public Day() {
    }

    public Day(Integer daynumber, String date, String check) {
        this.daynumber = daynumber;
        this.date = date;
        this.check = check;

    }

    public Integer getDaynumber() {
        return daynumber;
    }

    public void setDaynumber(Integer daynumber) {
        this.daynumber = daynumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }


}
