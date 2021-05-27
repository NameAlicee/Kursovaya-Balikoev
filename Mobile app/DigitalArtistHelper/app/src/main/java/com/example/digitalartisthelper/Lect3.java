package com.example.digitalartisthelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Lect3 extends AppCompatActivity implements View.OnClickListener {


    private Button Home;
    private Button Tasks;
    private Button Lections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lect3);

        Home = (Button) findViewById(R.id.HomeButtonL3);
        Home.setOnClickListener(this);

        Tasks = (Button) findViewById(R.id.TaskButtonL3);
        Tasks.setOnClickListener(this);

        Lections = (Button) findViewById(R.id.LectionButtonL3);
        Lections.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.HomeButtonL3:
                startActivity(new Intent(this,UserScreen.class));
                break;

            case R.id.TaskButtonL3:
                startActivity(new Intent(this, com.example.digitalartisthelper.Tasks.class));
                break;

            case R.id.LectionButtonL3:
                startActivity(new Intent(this,com.example.digitalartisthelper.Lections.class));
                break;
        }

    }
}