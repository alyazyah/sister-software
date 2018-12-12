package com.example.ecesu.courseplanner;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AppInterface extends AppCompatActivity
{

    //declare variables
    //private ArrayList<CourseItem> mCourseList; //making an array that will hold the names of the courses later crater
    //public CourseAdapter mAdapter; //declaring a variable from class CourseAdapter
    private Button course;
    private Button upcoming;
    private Button whatif;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_interface); //taking the id from activity_app_interface.xml
;
        //to get to the courses page
        course = findViewById(R.id.courses);
        course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //declaring the intent for courses
                Intent your_courses = new Intent(AppInterface.this, MidSemester.class);
                startActivity(your_courses);
            }
        });


        //the button for what if calculator
        whatif = findViewById(R.id.whatifcalculator);
        whatif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //declaring the intent for what if calculator
                Intent whatifintent = new Intent(AppInterface.this, WhatIfCalculator.class);
                startActivity(whatifintent);
            }
        });


        //the button for the upcoming deadlines
        upcoming = findViewById(R.id.Upcoming);
        upcoming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //declaring the intent for upcoming deadlines
                Intent upcomingintent = new Intent(AppInterface.this, UpcomingDeadline.class);
                startActivity(upcomingintent);
            }
        });

    }
}
