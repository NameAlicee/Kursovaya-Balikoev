package com.example.digitalartisthelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tas1 extends AppCompatActivity implements View.OnClickListener{

    private Button Home;
    private Button Tasks;
    private Button Lections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tas1);

        Home = (Button) findViewById(R.id.HomeButtonT1);
        Home.setOnClickListener(this);

        Tasks = (Button) findViewById(R.id.TaskButtonT1);
        Tasks.setOnClickListener(this);

        Lections = (Button) findViewById(R.id.LectionButtonT1);
        Lections.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.HomeButtonT1:
                startActivity(new Intent(this,UserScreen.class));
                break;

            case R.id.TaskButtonT1:
                startActivity(new Intent(this, com.example.digitalartisthelper.Tasks.class));
                break;

            case R.id.LectionButtonT1:
                startActivity(new Intent(this,com.example.digitalartisthelper.Lections.class));
                break;
        }

    }
}