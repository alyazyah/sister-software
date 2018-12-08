package com.example.ecesu.courseplanner;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExamplesViewHolder> {

    private ArrayList<ExampleItem> mExampleList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);

        void onDeleteClick(int position);
    }

    /*public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }*/

    public static class ExamplesViewHolder extends RecyclerView.ViewHolder{

        public TextView mNumber;
        public TextView mLine1;
        public TextView mLine2;
        //public ImageView mDeleteImage;

        public ExamplesViewHolder(@NonNull View itemView) {
            super(itemView);
            mNumber=itemView.findViewById(R.id.number);
            mLine1=itemView.findViewById(R.id.line1);
            mLine2=itemView.findViewById(R.id.line2);
            //mDeleteImage = itemView.findViewById(R.id.image_delete);

           /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION)
                            listener.onItemClick(position);
                    }
                }
            });

            mDeleteImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION)
                            listener.onDeleteClick(position);
                    }
                }
            });*/
        }
    }

    public ExampleAdapter(ArrayList<ExampleItem> exampleList) {
        mExampleList = exampleList;
    }

    @NonNull
    @Override
    public ExamplesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.example_item, viewGroup, false);
        ExamplesViewHolder evh = new ExamplesViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExamplesViewHolder holder, int i) {

        ExampleItem currentItem = mExampleList.get(i);

        holder.mLine1.setText(currentItem.getmText1());
        holder.mLine2.setText(currentItem.getmText2());
        holder.mNumber.setText(currentItem.getmnumber());
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}
