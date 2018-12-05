package com.example.ecesu.courseplanner;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.View;
import android.R.drawable;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static java.lang.Thread.sleep;

public class AppInterface extends AppCompatActivity
{

    //declare variables
    private ArrayList<CourseItem> mCourseList; //making an array that will hold the names of the courses later crater
    public CourseAdapter mAdapter; //declaring a variable from class CourseAdapter
    private Button midterm;
    private Button upcoming;
    private Button whatif;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_interface); //taking the id from activity_app_interface.xml
;
        //to get to the Midterm Weighed Grade page
        midterm = findViewById(R.id.Midtermeval);
        midterm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //declaring the intent for midterm evaluation
                Intent midintent = new Intent(AppInterface.this, MidSemester.class);
                startActivity(midintent);
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
                Intent upcomingintent = new Intent(AppInterface.this, UpcomingDeadlines.class);
                startActivity(upcomingintent);
            }
        });

        Spinner spinnerCourses = findViewById(R.id.spinner_courses); //making a new spinner (drpo down menu)

        mAdapter = new CourseAdapter(this, mCourseList); //getting the course names

        spinnerCourses.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                CourseItem clickedItem = (CourseItem) parent.getItemAtPosition(position); //it choses the selected course
                String clickedCourseName= clickedItem.getCourseName(); //getting the clicked course name and showing it on the drop down menu
                Toast.makeText(AppInterface.this, clickedCourseName + " selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                //does nothing when noting is clicked on
            }
        });

    }
}
