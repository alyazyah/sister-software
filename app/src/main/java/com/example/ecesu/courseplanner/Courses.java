package com.example.ecesu.courseplanner;

import java.util.ArrayList;

public class Courses {

    private String course;
    private String time;
    private ArrayList<String> date;

    public Courses(String course, String time, ArrayList<String> date) {
        this.course = course;
        this.time = time;
        this.date = date;
    }

    public String getCourse() {
        return course;
    }

    public String getTime() {
        return time;
    }

    public ArrayList<String> getDate(){ return date; }
}
