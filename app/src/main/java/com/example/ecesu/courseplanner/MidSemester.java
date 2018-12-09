package com.example.ecesu.courseplanner;

import java.util.ArrayList;
import java.lang.String;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ArrayAdapter;
import android.view.View.OnClickListener;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import android.widget.TextView;

public class MidSemester extends AppCompatActivity {

    Button save;
    EditText txtname, txttime, txtday;
    TextView tv;
    View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mid_semester);

        txtname = (EditText)findViewById(R.id.Name);
        txttime = (EditText)findViewById(R.id.Time);
        txtday = (EditText)findViewById(R.id.Day);
        save = (Button)findViewById(R.id.Save);
        tv=(TextView)findViewById(R.id.display);
        tv.setMovementMethod(new ScrollingMovementMethod());


        save.setOnClickListener(new OnClickListener() {

        @Override
                public void onClick(View v){
            tv.setText("Your Class: \n"+txtname.getText().toString()+"\n"+txtday.getText().toString()+"\n"+txttime.getText().toString()+"\n");
        }

    });

}

}

