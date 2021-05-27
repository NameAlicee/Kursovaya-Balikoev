package com.example.digitalartisthelper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Tasks extends AppCompatActivity implements View.OnClickListener{

    private Button Lections;
    private Button Home;

    RecyclerView recyclerView;
    DatabaseReference database;
     MyAdapterT myAdapterT;
     ArrayList<Task> listT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        recyclerView = findViewById(R.id.tasklist);
        database = FirebaseDatabase.getInstance().getReference("Tasks");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listT = new ArrayList<>();
        myAdapterT = new MyAdapterT(this,listT);
        recyclerView.setAdapter(myAdapterT);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot: snapshot.getChildren()){

                    Task task = dataSnapshot.getValue(Task.class);
                    listT.add(task);

                }

                myAdapterT.notifyDataSetChanged();

            }

            @Override
            public void onCancelled( DatabaseError error) {

            }
        });


        Home = (Button) findViewById(R.id.HomeButtonT);
        Home.setOnClickListener(this);

        Lections = (Button) findViewById(R.id.LectionButtonT);
        Lections.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.HomeButtonT:
                startActivity(new Intent(this,UserScreen.class));
                break;

            case R.id.LectionButtonT:
                startActivity(new Intent(this, com.example.digitalartisthelper.Lections.class));
                break;
        }

    }
}