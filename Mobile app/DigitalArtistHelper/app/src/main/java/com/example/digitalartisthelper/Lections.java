package com.example.digitalartisthelper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Lections extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView;
    DatabaseReference database;
    MyAdapter myAdapter;
    ArrayList<Lection> list;

    private Button Home;
    private Button Tasks;

    private TextView lect1;
    private TextView lect2;
    private TextView lect3;
    private TextView lect4;
    private TextView lect5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lections);



        Home = (Button) findViewById(R.id.HomeButtonL);
        Home.setOnClickListener(this);

        Tasks = (Button) findViewById(R.id.TaskButtonL);
        Tasks.setOnClickListener(this);

        lect1 = (TextView) findViewById(R.id.lectlink1);
        lect1.setOnClickListener(this);
        lect2 = (TextView) findViewById(R.id.lectlink2);
        lect2.setOnClickListener(this);
        lect3 = (TextView) findViewById(R.id.lectlink3);
        lect3.setOnClickListener(this);
        lect4 = (TextView) findViewById(R.id.lectlink4);
        lect4.setOnClickListener(this);
        lect5 = (TextView) findViewById(R.id.lectlink5);
        lect5.setOnClickListener(this);



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

            case R.id.lectlink1:
                startActivity(new Intent(this,Lect1.class));
                break;

            case R.id.lectlink2:
                startActivity(new Intent(this,Lect2.class));
                break;
        }

    }
}