package com.example.ecesu.courseplanner;

import java.util.ArrayList;
import java.lang.String;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ArrayAdapter;
import android.view.View.OnClickListener;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.TextView;
import android.util.SparseBooleanArray;

public class MidSemester extends AppCompatActivity {
    private ArrayList<Courses> courseList;
    public ArrayList<String> selection = new ArrayList<String>();
    private EditText txtInput;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private Context context = this;
    Button save;
    Button display;
    EditText txtname, txttime, txtday;
    CheckBox checkboxm, checkboxt, checkboxw, checkboxr, checkboxf;

    View v;


    /* ***********************************************************
     *  ******************************************************  *
     *  *           https://youtu.be/USbTcGx1mD0             *  *     <---Link I Used for all that sexy RecycleView stuff ;)
     *  ******************************************************  *
     *********************************************************** */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mid_semester);

        courseList = new ArrayList<>();
        txtname = (EditText) findViewById(R.id.Name);
        txttime = (EditText) findViewById(R.id.Time);
       // txtday = (EditText) findViewById(R.id.Day);
        checkboxm = (CheckBox) findViewById(R.id.m);
        checkboxt = (CheckBox) findViewById(R.id.t);
        checkboxw = (CheckBox) findViewById(R.id.w);
        checkboxr = (CheckBox) findViewById(R.id.r);
        checkboxf = (CheckBox) findViewById(R.id.f);
        save = (Button) findViewById(R.id.Save);
        display = (Button) findViewById(R.id.display);
        /*tv = (TextView) findViewById(R.id.display);
        tv.setMovementMethod(new ScrollingMovementMethod());*/
        //displayText = (TextView) findViewById((R.id.displayText));

        courseList = new ArrayList<>();

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //save info of classes

                SharedPreferences classInput = getSharedPreferences("userClass", Context.MODE_PRIVATE);

                String course = txtname.getText().toString();
                String time = txttime.getText().toString();

                Courses classEntered = new Courses(course, time);

                SharedPreferences.Editor editObj = classInput.edit();
                editObj.putString("courseName", course);
                editObj.putString("courseTime", time);
                // editObj.putString("courseDays", txtday.getText().toString());
                editObj.apply();
                Toast.makeText(context, "Class Saved!", Toast.LENGTH_LONG).show();

                if(checkboxm.isChecked() || checkboxt.isChecked() || checkboxw.isChecked() || checkboxr.isChecked() || checkboxf.isChecked()){
                    UserController userController = new UserController(context);
                    userController.saveDay(v);
                }
                //String day = txtday.getText().toString();

                courseList.add(classEntered);

            }
        });

        recyclerView = findViewById(R.id.midsemester);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new MidSemesterAdapter(courseList, this);

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

                courseList.remove(position);
                adapter.notifyDataSetChanged();
            }
        });

        helper.attachToRecyclerView(recyclerView);

    }

    /*  Im just gonna block this out to make sure that the Recycler View works. You can implement this later <3*/

    public void selectItem(View view)
    {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId())
        {
            case R.id.m:
                if (checked) {
                    selection.add("Monday");
                }
                else
                {
                    selection.remove("Monday");
                }
                break;

            case R.id.t:
                if (checked) {
                    selection.add("Tuesday");
                }
                else
                {
                    selection.remove("Tuesday");
                }
                break;

            case R.id.w:
                if (checked) {
                    selection.add("Wednesday");
                }
                else
                {
                    selection.remove("Wednesday");
                }
                break;

            case R.id.r:
                if (checked) {
                    selection.add("Thursday");
                }
                else
                {
                    selection.remove("Thursday");
                }
                break;

            case R.id.f:
                if (checked) {
                    selection.add("Friday");
                }
                else
                {
                    selection.remove("Friday");
                }
                break;

        }

    }


    /*

    public void displayData(View view) {
        //print out saved classes
        String final_class_selection = "";
        for (String Selections : selection)
        {
            final_class_selection = final_class_selection + Selections + " ";
        }

        SharedPreferences classInput = getSharedPreferences("userClass", Context.MODE_PRIVATE);

        String nameOfClass = classInput.getString("courseName", " ");
        String timeOfClass = classInput.getString("courseTime", " ");
     //   String daysOfClass = classInput.getString("courseDays", " ");


        /*displayText.setText("Class: " + nameOfClass + "\n" + "Time: " + timeOfClass + "\n" + "Days: " + final_class_selection);
        displayText.setEnabled(true);*/
    //}

}


