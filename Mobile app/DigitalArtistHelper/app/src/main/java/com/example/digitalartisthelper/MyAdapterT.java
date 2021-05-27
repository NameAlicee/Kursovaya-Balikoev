package com.example.digitalartisthelper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapterT  extends RecyclerView.Adapter<MyAdapterT.MyViewHolderT>{

    Context contextT;

    ArrayList<Task> listT;

    public MyAdapterT(Context contextT, ArrayList<Task> listT) {
        this.contextT = contextT;
        this.listT = listT;
    }

    @NonNull
    @Override
    public MyViewHolderT onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(contextT).inflate(R.layout.itemt,parent,false);
        return new MyViewHolderT(v);
    }

    @Override
    public void onBindViewHolder(@NonNull  MyAdapterT.MyViewHolderT holder, int position) {

        Task task = listT.get(position);
        holder.taskName.setText(task.getName());

    }

    @Override
    public int getItemCount() {
        return listT.size();
    }

    public static class MyViewHolderT extends RecyclerView.ViewHolder{

        TextView  taskName;

        public MyViewHolderT(@NonNull  View itemView) {
            super(itemView);

            taskName = itemView.findViewById(R.id.lectNamet);
        }
    }


}
