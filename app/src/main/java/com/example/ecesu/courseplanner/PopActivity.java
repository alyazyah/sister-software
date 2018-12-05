package com.example.ecesu.courseplanner;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class PopActivity extends Activity {

    Button closepopupmenu;
    protected ArrayList<String> arrayList;
    protected ArrayAdapter<String> adapter;
    protected EditText txtInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);

        /*ListView listview = findViewById(R.id.courselist);
        String [] items = {"Calculus on 14", "Math on 15"};
        arrayList=new ArrayList<>(Arrays.asList(items));
        adapter=new ArrayAdapter<>(this, R.layout.activity_upcoming_deadlines, R.id.upcomingdeadlines, arrayList);
        listview.setAdapter(adapter);
        txtInput=findViewById(R.id.DeadlineArray);*/

        closepopupmenu = findViewById(R.id.closepopup);
        closepopupmenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                /*String newItem = txtInput.getText().toString();
                arrayList.add(newItem);
                adapter.notifyDataSetChanged();*/
                finish();
            }
        });

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.5));

        WindowManager.LayoutParams layout = getWindow().getAttributes();
        layout.gravity = Gravity.CENTER;

        layout.x=0;
        layout.y=-20;

        getWindow().setAttributes(layout);


    }
}
