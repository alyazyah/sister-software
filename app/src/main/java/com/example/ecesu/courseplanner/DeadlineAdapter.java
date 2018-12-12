package com.example.ecesu.courseplanner;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class DeadlineAdapter extends RecyclerView.Adapter<DeadlineAdapter.ViewHolder>{

    private ArrayList<Deadline> ListDeadlines;
    private Context context;


    public DeadlineAdapter(ArrayList<Deadline> listDeadlines, Context context) {
        ListDeadlines = listDeadlines;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_deadline,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        Deadline deadlineItem = ListDeadlines.get(position);

        viewHolder.textViewTask.setText(deadlineItem.getTask());
        viewHolder.textViewDate.setText(deadlineItem.getDate());

    }

    @Override
    public int getItemCount() {
        return ListDeadlines.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewTask;
        public TextView textViewDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTask = itemView.findViewById(R.id.task);
            textViewDate = itemView.findViewById(R.id.date);
        }
    }

    public void removeItem(int position){
        ListDeadlines.remove(position);
        notifyItemRemoved(position);
    }

    public Deadline getDeadlineAt(int position){
        return ListDeadlines.get(position);
    }
}
