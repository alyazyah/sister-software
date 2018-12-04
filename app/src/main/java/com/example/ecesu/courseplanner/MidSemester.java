package com.example.ecesu.courseplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MidSemester extends AppCompatActivity {

    private Button midterm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mid_semester);

        midterm = findViewById(R.id.Midtermeval);
        midterm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMidSemester();
            }
        });
    }

    public void openMidSemester()
    {
        Intent midintent = new Intent(this, MidSemester.class);
        startActivity(midintent);
    }

}