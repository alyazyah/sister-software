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

public class MidSemsterAdapter extends RecyclerView.Adapter<MidSemsterAdapter.ViewHolder>{
    private ArrayList<String> courseList;
    private Context context;

    public MidSemsterAdapter(ArrayList<String> courseList, Context context){
        this.courseList = courseList;
        this.context = context;
    }

    @NonNull
    @Override
    public MidSemsterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_course,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MidSemsterAdapter.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}