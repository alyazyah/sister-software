package com.example.ecesu.courseplanner;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.lang.String;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.CheckBox;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MidSemester extends AppCompatActivity {
    private ArrayList<Courses> courseList;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private Context context = this;
    private Button save;
    private Button addCourse;
    EditText txtname, txttime;
    CheckBox checkboxm, checkboxt, checkboxw, checkboxr, checkboxf;
    private ArrayList<String> checkboxes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mid_semester);

        txtname = (EditText) findViewById(R.id.Name);
        txttime = (EditText) findViewById(R.id.Time);
        checkboxm = (CheckBox) findViewById(R.id.m);
        checkboxt = (CheckBox) findViewById(R.id.t);
        checkboxw = (CheckBox) findViewById(R.id.w);
        checkboxr = (CheckBox) findViewById(R.id.r);
        checkboxf = (CheckBox) findViewById(R.id.f);
        save = (Button) findViewById(R.id.Save);
        addCourse = (Button) findViewById(R.id.add);

        loadData();
        checkboxes = new ArrayList<>();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                saveData();
            }
        });

        addCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCourse();
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

    public void addCourse(){
        String course = txtname.getText().toString();
        String time = txttime.getText().toString();
        ArrayList <String> days = checkboxes;

        Courses classEntered = new Courses(course, time, days);

        if (classEntered == null || course.trim().equals("") || time.trim().equals(""))
        {
            Toast.makeText(getBaseContext(), "Input field is empty!", Toast.LENGTH_LONG).show();
        }
        else
        {
            courseList.add(classEntered);
        }
    }

    public void saveData(){
        SharedPreferences semesterPreferences = getSharedPreferences("courses pref",MODE_PRIVATE);
        SharedPreferences.Editor editor = semesterPreferences.edit();
        Gson gson = new Gson();

        String json = gson.toJson(courseList);
        editor.putString("course list", json);
        editor.apply();

        Toast.makeText(context, "Classes saved!", Toast.LENGTH_SHORT).show();
    }

    public void loadData(){
        SharedPreferences semesterPreferences = getSharedPreferences("courses pref", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = semesterPreferences.getString("course list", null);
        Type type = new TypeToken<ArrayList<Courses>>() {}.getType();
        courseList = gson.fromJson(json, type);

        if (courseList == null){
            courseList = new ArrayList<>();
        }
    }
    public void selectItem(View view)
    {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId())
        {
            case R.id.m:
                if (checked) {
                    checkboxes.add("Monday");
                }
                else
                {
                    checkboxes.remove("Monday");
                }
                break;

            case R.id.t:
                if (checked) {
                    checkboxes.add("Tuesday");
                }
                else
                {
                    checkboxes.remove("Tuesday");
                }
                break;

            case R.id.w:
                if (checked) {
                    checkboxes.add("Wednesday");
                }
                else
                {
                    checkboxes.remove("Wednesday");
                }
                break;

            case R.id.r:
                if (checked) {
                    checkboxes.add("Thursday");
                }
                else
                {
                    checkboxes.remove("Thursday");
                }
                break;

            case R.id.f:
                if (checked) {
                    checkboxes.add("Friday");
                }
                else
                {
                    checkboxes.remove("Friday");
                }
                break;

        }

    }
}


