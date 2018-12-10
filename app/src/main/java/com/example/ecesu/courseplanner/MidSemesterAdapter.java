package com.example.ecesu.courseplanner;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MidSemsterAdapter extends RecyclerView.Adapter<MidSemsterAdapter.ViewHolder>{

    private ArrayList<MidSemester> ListMidSemester;
    private Context context;

    public MidSemesterAdapter(ArrayList<MidSemester> listMidSemester, Context context){
        ListMidSemester = listMidSemester;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_midsemester,viewGroup, false);
        return new RecyclerView.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position){
        MidSemester midsemesterItem = ListMidSemester.get(position);

        viewHolder.textViewTask.setText(midsemesterItem.getTask());
        viewHolder.textViewTask.setText(midsemesterItem.getDate());

    }

    @Override
    public int getItemCount(){
        return ListMidSemester.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewTask;
        public TextView textViewDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTask = itemView.findViewById(R.id.task);
            textViewDate = itemView.findViewById(R.id.date);
        }
    }


}