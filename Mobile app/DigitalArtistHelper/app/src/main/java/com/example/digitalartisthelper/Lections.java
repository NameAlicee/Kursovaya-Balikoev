package com.example.digitalartisthelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Lections extends AppCompatActivity implements View.OnClickListener {

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