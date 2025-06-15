package com.example.a213049_muhakram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        int waktu = 2000;
        new Handler().postDelayed(() -> {
            Intent login = new Intent(Splash.this, login.class);
            startActivity(login);
            finish();
        }, waktu);


    }
}