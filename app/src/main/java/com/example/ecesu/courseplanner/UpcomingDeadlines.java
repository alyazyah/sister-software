package com.example.ecesu.courseplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UpcomingDeadlines extends AppCompatActivity {

    Button AddDeadline;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_deadlines);

        AddDeadline = findViewById(R.id.AddDeadline);

        AddDeadline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addingdeadline = new Intent(getApplicationContext(), PopActivity.class);
                startActivity(addingdeadline);
            }
        });
    }
}
