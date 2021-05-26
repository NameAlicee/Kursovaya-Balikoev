package com.example.digitalartisthelper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    Context context;

    ArrayList<Lection> list;

    public MyAdapter(Context context, ArrayList<Lection> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.iteml,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull  MyAdapter.MyViewHolder holder, int position) {

        Lection lection = list.get(position);
        holder.lectName.setText(lection.getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView lectName;

        public MyViewHolder(@NonNull  View itemView) {
            super(itemView);
            lectName = itemView.findViewById(R.id.lectNamel);
        }
    }

}
