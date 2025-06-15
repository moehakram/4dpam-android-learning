package com.example.a213049_muhakram;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_home);

    }
    public void onclikTugas1(View view) {
        Toast.makeText(this, "Praktikum Instalasi Software Android Studio", Toast.LENGTH_SHORT).show();
    }
        public void onclikTugas2(View view) {
            Intent intent = new Intent(MainActivity.this, tgs_layout.class);
            startActivity(intent);
    }
    public void onclikTugas3(View view) {
        Intent intent = new Intent(MainActivity.this, cardbank.class);
        startActivity(intent);
    }
    public void onclikTugas4(View view) {
        Intent intent = new Intent(MainActivity.this, gojek.class);
        startActivity(intent);
    }
    public void onclikTugas5(View view) {
        Intent intent = new Intent(MainActivity.this, login.class);
        startActivity(intent);
    }
    public void onclikTugas6(View view) {
        Intent intent = new Intent(MainActivity.this, programhitung.class);
        startActivity(intent);
    }
    public void onclikTugas7(View view) {
        Intent intent = new Intent(MainActivity.this, gofood.class);
        startActivity(intent);
    }
    public void onclikTugas8(View view) {
        Intent intent = new Intent(MainActivity.this, bayar.class);
        startActivity(intent);
    }
    public void onclikTugas9(View view) {
        Intent intent = new Intent(MainActivity.this, Splash.class);
        startActivity(intent);
    }
    public void onclikTugas10(View view) {
        Intent intent = new Intent(MainActivity.this, tambahmhs.class);
        startActivity(intent);
    }

}
