package com.example.ecesu.courseplanner;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static java.sql.Types.NULL;

public class UpcomingDeadline extends AppCompatActivity {
    //Variable declarations
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private Button addDeadline;
    private Button saveDeadline;
    private Context context = this;
    UpcomingDeadline upcomingDeadline = (UpcomingDeadline)context;
    private ArrayList<Deadline> deadlineList;

    EditText utask;
    EditText udate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_deadlines);

        //links variable and objects on layout
        utask = (EditText) upcomingDeadline.findViewById(R.id.task);
        udate = (EditText) upcomingDeadline.findViewById(R.id.date);
        addDeadline = findViewById(R.id.add);
        saveDeadline = findViewById(R.id.save);

        loadtasks(); //calls load function to load saved data

        addDeadline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                addtask();
                            }
        }); //when the addDeadline button is pressed the addtask() function is called
        saveDeadline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savetasks();
            }
        }); //when the saveDeadline button is pressed the savetasks() functions is called

        recyclerView = findViewById(R.id.upcomingdeadlines); //creates a variable for the recyclerview object on the app layout
        recyclerView.setHasFixedSize(true); //sets a fixed sized for the recycler view
        layoutManager = new LinearLayoutManager(this); //formatting for items within recyclerview
        adapter = new DeadlineAdapter(deadlineList, this); //creates the adapter for the current layout and recyclerview

        recyclerView.setLayoutManager(layoutManager); //assigns the layoutmanager to the recyclerview
        recyclerView.setAdapter(adapter); //assigns the adapter to the recyclerview

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            //function to interpret different gestures done on the recycler view
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
                //allows the user to move the items in a recycler view
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder target, int i) {
                //function allows users to swipe away items in order to delete them
                int position = target.getAdapterPosition();

                deadlineList.remove(position);
                adapter.notifyDataSetChanged();
            }
        });

        helper.attachToRecyclerView(recyclerView); //attaches the gesture object to the recyclerview

    }

    public void addtask(){
        //function creates a new task and puts it on the recyclerview
        //variable declarations
        String task = utask.getText().toString();
        String date = udate.getText().toString();

        Deadline deadlineEntered = new Deadline(task, date);

        //error check the input. Is it empty? Is the date valid?

        if (deadlineEntered == null || task.trim().equals("") || date.trim().equals(""))
        {
            Toast.makeText(getBaseContext(), "Input field is empty!", Toast.LENGTH_LONG).show();
        }
        else if(date.length()>10) {
            Toast.makeText(getBaseContext(), "Date is invalid!", Toast.LENGTH_LONG).show();
        }
        else
        {
            deadlineList.add(deadlineEntered);
        }


    }

    public void savetasks(){
        //function saves the deadline array to a sharedpreferences folder

        SharedPreferences tasksPreferences = getSharedPreferences("tasks pref",MODE_PRIVATE); //opens sharedpreferences folder
        SharedPreferences.Editor editor = tasksPreferences.edit(); //opens the editor for the shared preferences
        Gson gson = new Gson(); //create gson object

        String json = gson.toJson(deadlineList); //serializes the data
        editor.putString("task list", json); //assigns the string key for the data
        editor.apply(); //stores it in folder

        Toast.makeText(context, "Deadlines saved!", Toast.LENGTH_SHORT).show(); //message to indicate that the data has been saved
    }

    public void loadtasks(){
        // function loads previously saved data

        SharedPreferences tasksPreferences = getSharedPreferences("tasks pref", MODE_PRIVATE); //opens sharedpreferences folder
        Gson gson = new Gson(); //creates gson object
        String json = tasksPreferences.getString("task list", null); //returns serialized object
        Type type = new TypeToken<ArrayList<Deadline>>() {}.getType(); //creates deadline array
        deadlineList = gson.fromJson(json, type); //deserializes the object into the new array

        if (deadlineList == null){
            deadlineList = new ArrayList<>(); //if there is no saved data, a new array is created
        }
    }

}

