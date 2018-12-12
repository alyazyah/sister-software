package com.example.ecesu.courseplanner;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MidSemesterAdapter extends RecyclerView.Adapter<MidSemesterAdapter.ViewHolder>{
    private ArrayList<Courses> courseList;
    private Context context;

    public MidSemesterAdapter(ArrayList<Courses> courseList, Context context){
        this.courseList = courseList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_course,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Courses currentCourse = courseList.get(i);
        viewHolder.textViewCourse.setText(currentCourse.getCourse());
        viewHolder.textViewTime.setText(currentCourse.getTime());
        viewHolder.textViewDays.setText(currentCourse.getDate().toString());
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewCourse;
        public TextView textViewTime;
        public TextView textViewDays;
        public ViewHolder(View itemView) {
            super(itemView);

            textViewCourse = itemView.findViewById(R.id.course);
            textViewTime = itemView.findViewById(R.id.time);
            textViewDays = itemView.findViewById(R.id.days);
        }
    }

}