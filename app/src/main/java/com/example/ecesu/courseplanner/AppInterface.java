package com.example.ecesu.courseplanner;

import android.content.Context;
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

public class AppInterface extends AppCompatActivity
{

    //declare variables
    private ArrayList <CourseItem> mCourseList;
    private CourseAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_interface);

        initList();

        //Spinner spinnerCourses=findViewById(R.id.course_spinner);
        Spinner spinnerCourses = findViewById(R.id.activity_app_interface);

        mAdapter = new CourseAdapter(this, mCourseList);
        spinnerCourses.setAdapter(mAdapter);

        spinnerCourses.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                CourseItem clickedItem = (CourseItem) parent.getItemAtPosition(position);
                String clickedCourseName= clickedItem.getCourseName();
                Toast.makeText(AppInterface.this, clickedCourseName + " selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

    }
    private void initList()
    {
        mCourseList=new ArrayList<>();
        mCourseList.add(new CourseItem("Physics 212"));
        mCourseList.add(new CourseItem("Calculus 225"));
        mCourseList.add(new CourseItem("Circuits 307"));
        mCourseList.add(new CourseItem("SoftWare 327"));

    }
}
