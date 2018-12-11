package com.example.ecesu.courseplanner;

import java.util.ArrayList;
import java.lang.String;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
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

public class MidSemester extends AppCompatActivity {
    private ArrayList<String> courseList;
    //private ArrayAdapter<String> adapter;  // who is she chas?
    public ArrayList<String> selection = new ArrayList<String>();
    private EditText txtInput;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adap;
    private RecyclerView.LayoutManager layoutManager;
    private Context context = this;
    MidSemester midSemester = (MidSemester) context;
    Button save;
    EditText txtname, txttime, txtday;
    TextView tv, displayText;
    ListView listView;

    View v;


    /************************************************************
     *  ******************************************************  *
     *  *           https://youtu.be/USbTcGx1mD0             *  *     <---Link I Used for all that sexy RecycleView stuff ;)
     *  ******************************************************  *
     ************************************************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mid_semester);

        courseList = new ArrayList<>();
        //adap = new ArrayAdapter<String>(this, R.layout.list_course, R.id.txtitem, arrayList);   //who is she????

        txtname = (EditText) findViewById(R.id.Name);
        txttime = (EditText) findViewById(R.id.Time);
       // txtday = (EditText) findViewById(R.id.Day);
        save = (Button) findViewById(R.id.Save);
        tv = (TextView) findViewById(R.id.display);
        tv.setMovementMethod(new ScrollingMovementMethod());
        displayText = (TextView) findViewById((R.id.displayText));
    }

    /*  Im just gonna block this out to make sure that the Recycler View works. You can implement this later <3*/
    public void saveInfo(View view) {
        //save info of classes

        SharedPreferences classInput = getSharedPreferences("userClass", Context.MODE_PRIVATE);

        SharedPreferences.Editor editObj = classInput.edit();
        editObj.putString("courseName", txtname.getText().toString());
        editObj.putString("courseTime", txttime.getText().toString());
       // editObj.putString("courseDays", txtday.getText().toString());
        editObj.apply();
        Toast.makeText(this, "Class Saved!", Toast.LENGTH_LONG).show();
    }

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

        displayText.setText("Class: " + nameOfClass + "\n" + "Time: " + timeOfClass + "\n" + "Days: " + final_class_selection);
        displayText.setEnabled(true);
    }


   /* recyclerView = findViewById(R.id.midsemester);
    recyclerView.setHasFixedSize(true);
    layoutManager = new LinearLayoutManager(this);
    adapter = new DeadlineAdapter(deadlineList, this);

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

            deadlineList.remove(position);
            adapter.notifyDataSetChanged();
        }
    });

        helper.attachToRecyclerView(recyclerView);
*/
}


