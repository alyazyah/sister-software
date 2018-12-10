package com.example.ecesu.courseplanner;

public class Deadline {

    private String task;
    private String date;

    public Deadline(String task, String date) {
        this.task = task;
        this.date = date;
    }

    public String getTask() {
        return task;
    }

    public String getDate() {
        return date;
    }
}
