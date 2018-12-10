package com.example.ecesu.courseplanner;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
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
        deadlineList = new ArrayList<>();
        addDeadline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                String task = utask.getText().toString();
                String date = udate.getText().toString();
                Deadline userinput = new Deadline(task, date);
                deadlineList.add(userinput);

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

}
