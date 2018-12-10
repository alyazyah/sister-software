package com.example.ecesu.courseplanner;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.util.ArrayList;

public class UpcomingDeadline extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private Button addDeadline;
    private Context context = this;

    private ArrayList<Deadline> deadlineList;

    private EditText utask = (EditText) findViewById(R.id.task);
    private EditText udate = (EditText) findViewById(R.id.date);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_deadlines);

        addDeadline = findViewById(R.id.add);
        deadlineList = new ArrayList<>();
        addDeadline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String task = utask.getText().toString();
                String date = udate.getText().toString();

                deadlineList.add(new Deadline(task,date));
            }
        });

        recyclerView = findViewById(R.id.upcomingdeadlines);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new DeadlineAdapter(deadlineList, this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}
