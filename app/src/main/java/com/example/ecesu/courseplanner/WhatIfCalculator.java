package com.example.ecesu.courseplanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WhatIfCalculator extends AppCompatActivity {

    private EditText grade1;
    private EditText grade2;
    private EditText grade3;
    private EditText grade4;
    private EditText grade5;
    private EditText weight1;
    private EditText grade6;
    private EditText grade7;
    private EditText grade8;
    private EditText grade9;
    private EditText grade10; //all of the grade IDs
    private TextView averagegrades; //text view, the number that will be displayed at the end
    double result; //the result variable for average grades
    double g1, g2, g3, g4, g5, g6, g7, g8, g9, g10; //grade variables
    double w1, w2, w3, w4, w5, w6, w7, w8, w9, w10; //weigh variables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_if_calculator);

        grade1= findViewById(R.id.grade1);
        grade2= findViewById(R.id.grade2);
        grade3= findViewById(R.id.grade3);
        grade4= findViewById(R.id.grade4);
        grade5= findViewById(R.id.grade5);
        grade6= findViewById(R.id.grade6);
        grade7= findViewById(R.id.grade7);
        grade8= findViewById(R.id.grade8);
        grade9= findViewById(R.id.grade9);
        grade10= findViewById(R.id.grade10);

        weight1=findViewById(R.id.weight1);

        //button CALCULATE that calculates the end result
        Button whatif = findViewById(R.id.WhatIf);

        //the text view variable of avarage grades,
        averagegrades = findViewById(R.id.average);

        //basically saying when the CALCUALTE button is pressed it is going to do this
        whatif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //this is just trial. backend stuff doesn't work perfectly
                //declaring the grade variables
                g1 = Double.parseDouble(grade1.getText().toString());
                g2 = Double.valueOf(grade2.getText().toString());
                g3 = Double.valueOf(grade3.getText().toString());
                g4 = Double.valueOf(grade4.getText().toString());
                g5 = Double.valueOf(grade5.getText().toString());
                g6 = Double.valueOf(grade6.getText().toString());
                g7 = Double.valueOf(grade7.getText().toString());
                g8 = Double.valueOf(grade8.getText().toString());
                g9 = Double.valueOf(grade9.getText().toString());
                g10 = Double.valueOf(grade10.getText().toString());

                //declaring the weigh variables
                w1 = Double.parseDouble(weight1.getText().toString());
                w2 = Double.parseDouble(weight1.getText().toString());
                w3 = Double.parseDouble(weight1.getText().toString());
                w4 = Double.parseDouble(weight1.getText().toString());
                w5 = Double.parseDouble(weight1.getText().toString());
                w6 = Double.parseDouble(weight1.getText().toString());
                w7 = Double.parseDouble(weight1.getText().toString());
                w8 = Double.parseDouble(weight1.getText().toString());
                w9 = Double.parseDouble(weight1.getText().toString());
                w10 = Double.parseDouble(weight1.getText().toString());

                //this only works if there are all 20 variables entered by the user!
                //i don't know how to do it otherwise
                result = (((g1*w1)/100)+((g2*w2)/100)+((g3*w3)/100)+((g4*w4))/100+((g5*w5)/100)+((g6*w6)/100)+((g7*w7)/100)+((g8*w8)/100)+((g9*w9)/100)+((g10*w10)/100));

                //testing if the result is shown when calculate is press
                //yes the button works!
                averagegrades.setText(Double.toString(result));

            }
        });

    }
}
