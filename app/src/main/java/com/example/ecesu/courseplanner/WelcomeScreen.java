package com.example.ecesu.courseplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeScreen extends AppCompatActivity {

    private Button Cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen2);

        Cont = findViewById(R.id.Continue);
        Cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenWelcomeScreen();
            }
        });

    }
    public void OpenWelcomeScreen()
    {
        Intent intent = new Intent(this, AppInterface.class);
        startActivity(intent);
    }

}
