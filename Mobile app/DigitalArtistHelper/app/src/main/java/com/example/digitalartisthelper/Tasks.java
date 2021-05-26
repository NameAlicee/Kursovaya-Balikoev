package com.example.digitalartisthelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tasks extends AppCompatActivity implements View.OnClickListener{

    private Button Lections;
    private Button Home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

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