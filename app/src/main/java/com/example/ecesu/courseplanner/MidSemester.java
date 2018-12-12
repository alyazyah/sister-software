package com.example.ecesu.courseplanner;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.lang.String;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.CheckBox;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MidSemester extends AppCompatActivity {

    //initialliazes the variables for this part of the program
    private ArrayList<Courses> courseList;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private Context context = this;
    private Button save;
    private Button addCourse;
    EditText txtname, txttime;
    CheckBox checkboxm, checkboxt, checkboxw, checkboxr, checkboxf;
    private ArrayList<String> checkboxes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //calls this function when the activity is accessed
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mid_semester); //sets layout with the necessary attributes for the program

        //declares the variables and the corresponding element on the layout
        txtname = (EditText) findViewById(R.id.Name);
        txttime = (EditText) findViewById(R.id.Time);
        checkboxm = (CheckBox) findViewById(R.id.m);
        checkboxt = (CheckBox) findViewById(R.id.t);
        checkboxw = (CheckBox) findViewById(R.id.w);
        checkboxr = (CheckBox) findViewById(R.id.r);
        checkboxf = (CheckBox) findViewById(R.id.f);
        save = (Button) findViewById(R.id.Save);
        addCourse = (Button) findViewById(R.id.add);

        loadData(); //calls Load function to load the saved data to the from the lake

        checkboxes = new ArrayList<>(); //creates the space for the checkboxes array list

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                saveData();
            }
        }); //calls save function when save button is clicked

        addCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCourse();
            }
        }); //calls add button to add item

        recyclerView = findViewById(R.id.midsemester); //seeks the recyclerview found in the current context/layout
        recyclerView.setHasFixedSize(true); //maintains the size of the recyclerview constant
        layoutManager = new LinearLayoutManager(this); //determines the formatting of the objects within the recycler view
        adapter = new MidSemesterAdapter(courseList, this); // establishes a relationship using the MidSemester Adapter and the activity layout

        recyclerView.setLayoutManager(layoutManager); //assigns the layout manager to the recycler view
        recyclerView.setAdapter(adapter); //assigns the adapter to the recycler view

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            //function in charge of taking in gestures from the user with the recycler view
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
               //allows the user to modify the order of the items with the list
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder target, int i) {
                //allows the user to swipe objects away from the list
                int position = target.getAdapterPosition();

                courseList.remove(position);
                adapter.notifyDataSetChanged();
            }
        });

        helper.attachToRecyclerView(recyclerView); //attaches the recycler view to the item touch helped
    }

    public void addCourse(){
        //This function adds a course to the RecycleView

        //declaration of variables
        String course = txtname.getText().toString(); //text for course name
        String time = txttime.getText().toString();   //text for time
        ArrayList <String> days = checkboxes;         //array for checkboxes state

        Courses classEntered = new Courses(course, time, days); //creates a course variable with the gathered data

        //error checks user input
        if (classEntered == null || course.trim().equals("") || time.trim().equals(""))
        {
            Toast.makeText(getBaseContext(), "Input field is empty!", Toast.LENGTH_LONG).show();
        }
        else
        {
            courseList.add(classEntered);
        }
    }

    public void saveData(){
        //Saves the data on the activity into SharedPreferences. It will keep the memory if you leave the activity page or close the app
        SharedPreferences semesterPreferences = getSharedPreferences("courses pref",MODE_PRIVATE); //creates the shared preference folder for courses
        SharedPreferences.Editor editor = semesterPreferences.edit(); //accesses the editor function of the sharedpreferences
        Gson gson = new Gson(); //creates a Gson object to serialize variable

        String json = gson.toJson(courseList); //serializes variable and stores a string key to access it
        editor.putString("course list", json); //stores the key into shared preferences
        editor.apply(); //applies changes

        Toast.makeText(context, "Classes saved!", Toast.LENGTH_SHORT).show(); //popup explaining that courses were saved
    }

    public void loadData(){
        //This functions loads the data from shared preferences
        SharedPreferences semesterPreferences = getSharedPreferences("courses pref", MODE_PRIVATE); //opens shared preferences folder for courses
        Gson gson = new Gson(); //creates a Gson object
        String json = semesterPreferences.getString("course list", null); //obtains the variable data from the shared preferences folder
        Type type = new TypeToken<ArrayList<Courses>>() {}.getType(); //create a new array based on the type of the array stored
        courseList = gson.fromJson(json, type); //deserializes the data found in the shared preferences and stores array into courseList

        if (courseList == null){
            courseList = new ArrayList<>(); //creates spaces for courseList if the courseList had not been created
        }
    }
    public void selectItem(View view)
    {
        //This function verifies if and which checkboxes for the days are marked
        boolean checked = ((CheckBox) view).isChecked(); //boolean function to determine if the box is checked
        switch (view.getId())
        {
            //switch statements verifies different states of each checkbox and either adds or removes them from checkbox array accordingly
            case R.id.m:
                if (checked) {
                    checkboxes.add("Monday");
                }
                else
                {
                    checkboxes.remove("Monday");
                }
                break;

            case R.id.t:
                if (checked) {
                    checkboxes.add("Tuesday");
                }
                else
                {
                    checkboxes.remove("Tuesday");
                }
                break;

            case R.id.w:
                if (checked) {
                    checkboxes.add("Wednesday");
                }
                else
                {
                    checkboxes.remove("Wednesday");
                }
                break;

            case R.id.r:
                if (checked) {
                    checkboxes.add("Thursday");
                }
                else
                {
                    checkboxes.remove("Thursday");
                }
                break;

            case R.id.f:
                if (checked) {
                    checkboxes.add("Friday");
                }
                else
                {
                    checkboxes.remove("Friday");
                }
                break;

        }

    }
}


