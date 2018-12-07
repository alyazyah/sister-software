package com.example.ecesu.courseplanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Double.*;

public class WhatIfCalculator extends AppCompatActivity {

    private EditText grade1;
    private EditText grade2;
    private EditText grade3;
    private EditText grade4;
    private EditText grade5;
    private EditText grade6;
    private EditText grade7;
    private EditText grade8;
    private EditText grade9;
    private EditText grade10; //all of the grade IDs
    private EditText weight1;
    private EditText weight2;
    private EditText weight3;
    private EditText weight4;
    private EditText weight5;
    private EditText weight6;
    private EditText weight7;
    private EditText weight8;
    private EditText weight9;
    private EditText weight10;
    private TextView averagegrades; //text view, the number that will be displayed at the end
    double result; //the result variable for average grades
    double grades[]=new double[10]; //array for grades
    double weights[]=new double[10]; //array for weights
    double totalw; // variable to check number of weights

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
        weight2=findViewById(R.id.weight2);
        weight3=findViewById(R.id.weight3);
        weight4=findViewById(R.id.weight4);
        weight5=findViewById(R.id.weight5);
        weight6=findViewById(R.id.weight6);
        weight7=findViewById(R.id.weight7);
        weight8=findViewById(R.id.weight8);
        weight9=findViewById(R.id.weight9);
        weight10=findViewById(R.id.weight10);


        //button CALCULATE that calculates the end result
        Button whatif = findViewById(R.id.WhatIf);

        //the text view variable of avarage grades,
        averagegrades = findViewById(R.id.average);

        // calculate total number of weights entered
        for (int i = 0; i < 10; i++) {
            totalw = weights[i];
        }

        //basically saying when the CALCULATE button is pressed it is going to do this
        whatif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //this is just trial. backend stuff doesn't work perfectly
                //if-else loops get text from edit fields and set them to 0.0 if there is no value in the field

                if (!TextUtils.isEmpty(grade1.getText()))
                    grades[0] = parseDouble(grade1.getText().toString());
                else
                    grades[0]=0.0;

                if (!TextUtils.isEmpty(grade2.getText()))
                    grades[1] = parseDouble(grade2.getText().toString());
                else
                    grades[1]=0.0;

                if (!TextUtils.isEmpty(grade3.getText()))
                    grades[2] = parseDouble(grade3.getText().toString());
                else
                    grades[2]=0.0;

                if (!TextUtils.isEmpty(grade4.getText()))
                    grades[3] = parseDouble(grade4.getText().toString());
                else
                    grades[3]=0.0;

                if (!TextUtils.isEmpty(grade5.getText()))
                    grades[4] = parseDouble(grade5.getText().toString());
                else
                    grades[4]=0.0;

                if (!TextUtils.isEmpty(grade6.getText()))
                    grades[5] = parseDouble(grade6.getText().toString());
                else
                    grades[5]=0.0;

                if (!TextUtils.isEmpty(grade7.getText()))
                    grades[6] = parseDouble(grade7.getText().toString());
                else
                    grades[6]=0.0;

                if (!TextUtils.isEmpty(grade8.getText()))
                    grades[7] = parseDouble(grade8.getText().toString());
                else
                    grades[7]=0.0;

                if (!TextUtils.isEmpty(grade9.getText()))
                    grades[8] = parseDouble(grade9.getText().toString());
                else
                    grades[8]=0.0;

                if (!TextUtils.isEmpty(grade10.getText()))
                    grades[9] = parseDouble(grade10.getText().toString());
                else
                    grades[9]=0.0;

                //declaring the weight variables
                if (!TextUtils.isEmpty(weight1.getText()))
                    weights[0] = parseDouble(weight1.getText().toString());

                else
                    weights[0]=0.0;

                if (!TextUtils.isEmpty(weight2.getText()))
                    weights[1] = parseDouble(weight2.getText().toString());
                else
                    weights[1]=0.0;

                if (!TextUtils.isEmpty(weight3.getText()))
                    weights[2] = parseDouble(weight3.getText().toString());
                else
                    weights[2]=0.0;

                if (!TextUtils.isEmpty(weight4.getText()))
                    weights[3] = parseDouble(weight4.getText().toString());
                else
                    weights[3]=0.0;

                if (!TextUtils.isEmpty(weight5.getText()))
                    weights[4] = parseDouble(weight5.getText().toString());
                else
                    weights[4]=0.0;

                if (!TextUtils.isEmpty(weight6.getText()))
                    weights[5] = parseDouble(weight6.getText().toString());
                else
                    weights[5]=0.0;

                if (!TextUtils.isEmpty(weight7.getText()))
                    weights[6] = parseDouble(weight7.getText().toString());
                else
                    weights[6]=0.0;

                if (!TextUtils.isEmpty(weight8.getText()))
                    weights[7] = parseDouble(weight8.getText().toString());
                else
                    weights[7]=0.0;

                if (!TextUtils.isEmpty(weight9.getText()))
                    weights[8] = parseDouble(weight9.getText().toString());
                else
                    weights[8]=0.0;

                if (!TextUtils.isEmpty(weight10.getText()))
                    weights[9] = parseDouble(weight10.getText().toString());
                else
                    weights[9]=0.0;

                // if the total weights are greater than a 100, display an error message
              //  if (totalw > 100)
                //{
                    //SNACKBAR
                //}


                //loops for average

                for (int i=0; i<10;i++){
                    result+=((grades[i]*weights[i])/100);
                }
                //testing if the result is shown when calculate is press
                //yes the button works!
                Double resulttext = parseDouble(String.format("%.2f",result));
                averagegrades.setText(Double.toString(resulttext));
                result = 0.0;  
            }
        });

    }
}
