package com.example.a213049_muhakram;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button btnDaftar = findViewById(R.id.btnDaftar);
        btnDaftar.setOnClickListener(view -> {
            Intent intent = new Intent(login.this, daftar.class);
            startActivity(intent);
        });

        Button loginButton = findViewById(R.id.btnLogin);
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);

        loginButton.setOnClickListener(view -> {
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if (username.equals("213049") && password.equals("akram")) {
                Intent intent = new Intent(login.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(login.this, "Username atau Password Anda Salah", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
