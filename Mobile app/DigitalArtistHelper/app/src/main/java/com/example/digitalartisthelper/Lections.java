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

public class Lections extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView;
    DatabaseReference database;
    MyAdapter myAdapter;
    ArrayList<Lection> list;

    private Button Home;
    private Button Tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lections);



        Home = (Button) findViewById(R.id.HomeButtonL);
        Home.setOnClickListener(this);

        Tasks = (Button) findViewById(R.id.TaskButtonL);
        Tasks.setOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.recylerLections);
        database = FirebaseDatabase.getInstance().getReference("Lections");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        myAdapter = new MyAdapter(this,list);
        recyclerView.setAdapter(myAdapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Lection lection = dataSnapshot.getValue(Lection.class);
                    list.add(lection);
                }
                myAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {

            }
        });



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.HomeButtonL:
                startActivity(new Intent(this,UserScreen.class));
                break;

            case R.id.TaskButtonL:
                startActivity(new Intent(this, com.example.digitalartisthelper.Tasks.class));
                break;
        }

    }
}