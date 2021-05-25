package com.example.digitalartisthelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserScreen extends AppCompatActivity implements View.OnClickListener {

    private Button Lections;
    private  Button Tasks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_screen);

        Lections = (Button) findViewById(R.id.LectionButton);
        Lections.setOnClickListener(this);

        Tasks = (Button) findViewById(R.id.TaskButton);
        Tasks.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.LectionButton:
                startActivity(new Intent(this, com.example.digitalartisthelper.Lections.class));
                break;


            case R.id.TaskButton:
                startActivity(new Intent(this, com.example.digitalartisthelper.Tasks.class));
                break;
        }



    }
}