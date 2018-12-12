package com.example.ecesu.courseplanner;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class DeadlineAdapter extends RecyclerView.Adapter<DeadlineAdapter.ViewHolder> {
    // Adapter Class

    //Variable declarations
    private ArrayList<Deadline> ListDeadlines;
    private Context context;


    public DeadlineAdapter(ArrayList<Deadline> listDeadlines, Context context) {
        //constructor function for DeadlineAdapter
        ListDeadlines = listDeadlines;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //creates spacing for the items in the recyclerview
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_deadline, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        //sets the values of the items in the recycler view
        Deadline deadlineItem = ListDeadlines.get(position);

        viewHolder.textViewTask.setText(deadlineItem.getTask());
        viewHolder.textViewDate.setText(deadlineItem.getDate());

    }

    @Override
    public int getItemCount() {
        //returns the amount of items in the array
        return ListDeadlines.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        //declares the variables for the text boxes
        public TextView textViewTask;
        public TextView textViewDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTask = itemView.findViewById(R.id.task); //takes in the value from the text box for task
            textViewDate = itemView.findViewById(R.id.date); //takes in the value from the text box for date
        }
    }
}