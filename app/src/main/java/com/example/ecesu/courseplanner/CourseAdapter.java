package com.example.ecesu.courseplanner;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CourseAdapter extends ArrayAdapter<CourseItem>
{
    public CourseAdapter(Context context, ArrayList<CourseItem> courseList)
    {
        super(context, 0, courseList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent)
    {
        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(
                   // R.layout.course_spinner, parent, false
                    R.layout.activity_app_interface, parent, false
            );
        }
        TextView textViewName = convertView.findViewById(R.id.text_view_name);

        CourseItem currentItem = getItem(position);

        if (currentItem != null)
        {
            textViewName.setText(currentItem.getCourseName());
        }
        return convertView;
    }
}

