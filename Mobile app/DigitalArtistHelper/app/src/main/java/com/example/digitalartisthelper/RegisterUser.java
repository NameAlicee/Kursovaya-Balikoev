package com.example.digitalartisthelper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class RegisterUser extends AppCompatActivity implements View.OnClickListener {

    private TextView registerUser;
    private EditText editTextFullName, editTextAge, editTextEmail, editTextPassword;
    private ProgressBar progressBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        mAuth = FirebaseAuth.getInstance();

        registerUser = (Button) findViewById(R.id.registerUserButton);
        registerUser.setOnClickListener(this);
        editTextFullName = (EditText) findViewById(R.id.Name);
        editTextAge = (EditText) findViewById(R.id.Age);
        editTextEmail = (EditText) findViewById(R.id.email);
        editTextPassword = (EditText) findViewById(R.id.Password);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.registerUserButton:
                registerUser();
                break;
        }
    }

    private void registerUser() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String fullname = editTextFullName.getText().toString().trim();
        String age = editTextAge.getText().toString().trim();

        if (fullname.isEmpty()) {
            editTextFullName.setError("Everybody has a name,pal. i Need yours");
            editTextFullName.requestFocus();
        }

        if (age.isEmpty()) {
            editTextAge.setError("Repeat your age please");
            editTextAge.requestFocus();
        }
        if (email.isEmpty()) {
            editTextEmail.setError("I need your email");
            editTextEmail.requestFocus();
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("You need a valid email");
            editTextEmail.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            editTextPassword.setError("I need your codeword");
            editTextPassword.requestFocus();
            return;
        }
        if (password.length() < 6) {
            editTextPassword.setError("codeword must contain at less 6 characters ");
            editTextPassword.requestFocus();
            return;
        }
    }
}


