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

public class UpcomingDeadline extends AppCompatActivity {

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

        utask = (EditText) upcomingDeadline.findViewById(R.id.task);
        udate = (EditText) upcomingDeadline.findViewById(R.id.date);
        addDeadline = findViewById(R.id.add);
        saveDeadline = findViewById(R.id.save);

        loadtasks();

        addDeadline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                addtask();
                            }
        });
        saveDeadline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savetasks();
            }
        });

        recyclerView = findViewById(R.id.upcomingdeadlines);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new DeadlineAdapter(deadlineList, this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder target, int i) {
                int position = target.getAdapterPosition();

                deadlineList.remove(position);
                adapter.notifyDataSetChanged();
            }
        });

        helper.attachToRecyclerView(recyclerView);

    }

    public void addtask(){
        String task = utask.getText().toString();
        String date = udate.getText().toString();
        Deadline userinput = new Deadline(task, date);
        deadlineList.add(userinput);
    }

    public void savetasks(){
        SharedPreferences tasksPreferences = getSharedPreferences("tasks pref",MODE_PRIVATE);
        SharedPreferences.Editor editor = tasksPreferences.edit();
        Gson gson = new Gson();

        String json = gson.toJson(deadlineList);
        editor.putString("task list", json);
        editor.apply();

        Toast.makeText(context, "Deadlines saved!", Toast.LENGTH_SHORT).show();
    }

    public void loadtasks(){
        SharedPreferences tasksPreferences = getSharedPreferences("tasks pref", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = tasksPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<Deadline>>() {}.getType();
        deadlineList = gson.fromJson(json, type);

        if (deadlineList == null){
            deadlineList = new ArrayList<>();
        }
    }

}

