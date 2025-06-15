package com.example.a213049_muhakram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class gojek extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gojek);
    }
    public void goofood(View view) {
        Intent intent = new Intent(gojek.this, gofood.class);
        startActivity(intent);
    }
}