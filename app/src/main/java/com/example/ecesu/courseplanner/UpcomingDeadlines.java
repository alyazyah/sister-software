package com.example.ecesu.courseplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class UpcomingDeadlines extends AppCompatActivity {

    private ArrayList<ExampleItem> mExampleList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Button AddDeadline;
    private Button RemoveDeadline;
    private EditText Add;
    private EditText Remove;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_deadlines);

        createExampleList();
        buildRecyclerView();
        setButtons();
    }
    public void changeItem(int position, String text) {
        mExampleList.get(position).changeText1(text);
        mAdapter.notifyItemChanged(position);
    }
    public void insertItem (int position)
    {
        mExampleList.add(position, new ExampleItem("new item", "neeew", "B" + position));
        mAdapter.notifyItemInserted(position);
    }

    public void removeItem (int position)
    {
        mExampleList.remove(position);
        mAdapter.notifyItemRemoved(position);

    }
    public void createExampleList()
    {
        mExampleList = new ArrayList<>();
        mExampleList.add(new ExampleItem("Line 1", "Line 2", "B"));
        mExampleList.add(new ExampleItem("Line 3", "Line 4", "D"));
        mExampleList.add(new ExampleItem("Line 5", "Line 6","H"));
    }
    public void buildRecyclerView()
    {
        mRecyclerView = findViewById(R.id.courselist);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

       /* mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                changeItem(position, "Clicked");
            }

            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
            }
        });*/
    }
    public void setButtons() {
        AddDeadline = findViewById(R.id.AddDeadline);
        RemoveDeadline = findViewById(R.id.RemoveDeadline);
        Add = findViewById(R.id.edittext_add);
        Remove = findViewById(R.id.edittext_remove);

        AddDeadline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(Add.getText().toString());
                position=position+1;
                insertItem(position);

                /*Intent addingdeadline = new Intent(getApplicationContext(), PopActivity.class);
                startActivity(addingdeadline);*/
            }
        });

        RemoveDeadline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int position = Integer.parseInt(Remove.getText().toString());
                position=position+1;
                removeItem(position);
            }
        });
    }
}
