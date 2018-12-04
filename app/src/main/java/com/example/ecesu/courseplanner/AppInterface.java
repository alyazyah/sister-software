package com.example.ecesu.courseplanner;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.View;
import android.R.drawable;
import android.widget.AutoCompleteTextView;
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


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_interface); //taking the id from activity_app_interface.xml

        //initList(); //function call to create the array list of course names

        Spinner spinnerCourses = findViewById(R.id.spinner_courses); //making a new spinner (drpo down menu)

        mAdapter = new CourseAdapter(this, mCourseList); //getting the course names
        //spinnerCourses.setAdapter(mAdapter); //putting the course names into the spinner

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
    /*private void initList()
    {
        //creating the course name array list that holds up demo course names (wil not be used in the back end)
        //in the normal code we will have the user enter whatever and save it into the array list, that wll be backend
        mCourseList = new ArrayList<>();
        mCourseList.add(new CourseItem("Physics 212"));
        mCourseList.add(new CourseItem("Calculus 225"));
        mCourseList.add(new CourseItem("Circuits 307"));
        mCourseList.add(new CourseItem("SoftWare 327"));

    }*/
}
