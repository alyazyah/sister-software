package com.example.ecesu.courseplanner;

public class Courses {

    private String course;
    private String time;
    //private String date;

    public Courses(String course, String time) {
        this.course = course;
        this.time = time;
        //this.date = date;
    }

    public String getCourse() {
        return course;
    }

    public String getTime() {
        return time;
    }

    /*public String getDate(){
        return date;
    }*/
}
