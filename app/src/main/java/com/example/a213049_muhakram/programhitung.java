package com.example.a213049_muhakram;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;

public class programhitung extends AppCompatActivity {

    Button hitung;
    EditText panjang;
    EditText lebar;
    CheckBox ket;
    TextView hasil;
    SeekBar seekbar;
    TextView tampilseek;
    SwitchCompat aktif;
    LinearLayout tampil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.program_hitung);
        hitung = findViewById(R.id.hitung);
        panjang = findViewById(R.id.panjang);
        lebar = findViewById(R.id.lebar);
        ket = findViewById(R.id.ket);
        hasil = findViewById(R.id.hasil);
        seekbar = findViewById(R.id.seekbar);
        tampilseek = findViewById(R.id.tampilseekbar);
        tampil = findViewById(R.id.tampil);
        aktif = findViewById(R.id.aktif);

        hitung.setOnClickListener(view -> {
            if(panjang.getText().toString().isEmpty()){
                panjang.setError("Masukkan Panjang");
            } else if (lebar.getText().toString().isEmpty()) {
                lebar.setError("Masukkan Lebar");
            } else {
                int angka1 = Integer.parseInt(panjang.getText().toString());
                int angka2 = Integer.parseInt(lebar.getText().toString());
                int hasilnya = angka1 * angka2;
                if (ket.isChecked()){
                    String s = "Luas persegi panjang : "+hasilnya;
                    hasil.setText(s);
                }else{
                    hasil.setText(String.valueOf(hasilnya));
                }

                ket.setOnCheckedChangeListener((compoundButton, b) -> {
                    if (ket.isChecked()){
                        String s = "Luas persegi panjang : "+hasilnya;
                        hasil.setText(s);
                    }else{
                        hasil.setText(String.valueOf(hasilnya));
                    }
                });



            }
        });

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                String p = "Progress : " + i + "%";
                tampilseek.setText(p);
                lebar.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        aktif.setOnCheckedChangeListener((compoundButton, b) -> {
            if(!aktif.isChecked()){
                tampil.setVisibility(View.GONE);
                aktif.setTextColor(ContextCompat.getColor(this, R.color.merah));
                aktif.setText(R.string.ntampil);
            }else {
                tampil.setVisibility(View.VISIBLE);
                aktif.setTextColor(ContextCompat.getColor(this, R.color.hijau));
                aktif.setText(R.string.tampil);
            }
        });
    }
}