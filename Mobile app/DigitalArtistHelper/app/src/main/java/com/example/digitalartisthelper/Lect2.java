package com.example.digitalartisthelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Lect2 extends AppCompatActivity implements View.OnClickListener {

    private Button Home;
    private Button Tasks;
    private Button Lections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lect2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.HomeButtonL1:
                startActivity(new Intent(this,UserScreen.class));
                break;

            case R.id.TaskButtonL1:
                startActivity(new Intent(this, com.example.digitalartisthelper.Tasks.class));
                break;

            case R.id.LectionButtonL1:
                startActivity(new Intent(this,com.example.digitalartisthelper.Lections.class));
                break;
        }


    }
}