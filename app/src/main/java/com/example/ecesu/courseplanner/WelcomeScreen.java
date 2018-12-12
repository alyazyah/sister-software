package com.example.ecesu.courseplanner;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeScreen extends AppCompatActivity {
    //class for welcome page
    private static int SPLASH_TIME_OUT=2000;
    //waits for 2 seconds before switching activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run()
            {
                Intent appIntent = new Intent(WelcomeScreen.this, AppInterface.class);
                startActivity(appIntent);
                finish();
                //shows activity for 2 seconds
            }
        }, SPLASH_TIME_OUT);
    }
}