package com.example.ecesu.courseplanner;

import java.util.ArrayList;

public class Courses {
    //custom class: Courses

    //variable declarations
    private String course;
    private String time;
    private ArrayList<String> date;

    //Courses constructor
    public Courses(String course, String time, ArrayList<String> date) {
        this.course = course;
        this.time = time;
        this.date = date;
    }

    //getter functions for course, times and dates
    public String getCourse() {
        return course;
    }

    public String getTime() {
        return time;
    }

    public ArrayList<String> getDate(){ return date; }
}
