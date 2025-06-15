package com.example.a213049_muhakram;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class gofood extends AppCompatActivity {


    private int[] jml = {0, 0, 0};
    private TextView[] quantity;
    private TextView hargaTotal;

    private int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gofood);

        Button[] minusBtn = {findViewById(R.id.minus_btn1), findViewById(R.id.minus_btn2), findViewById(R.id.minus_btn3)};
        Button[] plusBtn = {findViewById(R.id.plus_btn1), findViewById(R.id.plus_btn2), findViewById(R.id.plus_btn3)};
        quantity = new TextView[]{findViewById(R.id.quantity1), findViewById(R.id.quantity2), findViewById(R.id.quantity3)};
        hargaTotal = findViewById(R.id.harga);

        for (int i = 0; i < quantity.length; i++) {
            final int index = i;
            minusBtn[i].setOnClickListener(v -> {
                if (jml[index] > 0) {
                    jml[index]--;
                    quantity[index].setText(String.valueOf(jml[index]));
                    updateHargaTotal();
                }
            });

            plusBtn[i].setOnClickListener(v -> {
                jml[index]++;
                quantity[index].setText(String.valueOf(jml[index]));
                updateHargaTotal();
            });
        }

        // Memanggil metode updateHargaTotal() untuk mengupdate harga total saat tata letak diinisialisasi
        updateHargaTotal();
    }

    private void updateHargaTotal() {
        final int[] harga = {10000, 15000, 20000};
        total = 0;
        for (int i = 0; i < 3; i++) {
            total += jml[i] * harga[i];
        }
        String htot = "Rp" + String.format(Locale.US,"%,d", total).replace(',', '.');
        hargaTotal.setText(htot);
    }

    public void onclikBayar(View view) {
        int totalQuantity = 0;
        for (TextView textView : quantity) {
            int jml = Integer.parseInt(textView.getText().toString());
            totalQuantity += jml;
        }

        if (totalQuantity == 0) {
            Toast.makeText(this, "Anda belum memesan makanan!", Toast.LENGTH_SHORT).show();
        } else {
            String[] namaMenu = {"Menu 1", "Menu 2", "Menu 3"};
            Intent intent = new Intent(gofood.this, bayar.class);
            intent.putExtra("hargafix", total);
            intent.putExtra("jumlah_pesanan", jml);
            intent.putExtra("nama_menu", namaMenu);
            startActivity(intent);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntArray("jml", jml);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState != null) {
            jml = savedInstanceState.getIntArray("jml");

            for (int i = 0; i < quantity.length; i++) {
                quantity[i].setText(String.valueOf(jml[i]));
            }
            updateHargaTotal();
        }
    }
}
