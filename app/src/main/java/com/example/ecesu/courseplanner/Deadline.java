package com.example.ecesu.courseplanner;

public class Deadline {

    //custom class: Deadline

    //variable declarations
    private String task;
    private String date;

    //constructor function for deadline
    public Deadline(String task, String date) {
        this.task = task;
        this.date = date;
    }

    //getter functions for deadline
    public String getTask() {
        return task;
    }

    public String getDate() {
        return date;
    }
}
