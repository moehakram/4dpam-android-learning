package com.example.a213049_muhakram;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.HashMap;


public class tambahmhs extends AppCompatActivity {
    private EditText editTextNim;
    private EditText editTextNama;
    private EditText editTextJurusan;

    private Button buttonTambah;
    private Button buttonTampil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambahmhs);

        editTextNim = findViewById(R.id.editTextNim);
        editTextNama = findViewById(R.id.editTextNama);
        editTextJurusan = findViewById(R.id.editTextJurusan);

        buttonTambah = findViewById(R.id.buttonAdd);
        buttonTampil = findViewById(R.id.buttonView);

        buttonTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tambahMhs();
            }
        });

        buttonTampil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(tambahmhs.this,alltampilmhs.class));
            }
        });
    }

    private void tambahMhs(){

        final String nim = editTextNim.getText().toString().trim();
        final String nama = editTextNama.getText().toString().trim();
        final String jurusan = editTextJurusan.getText().toString().trim();

        class AddEmployee extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(tambahmhs.this,"Menambahkan...","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(tambahmhs.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(konfigurasi.KEY_MHS_NIM,nim);
                params.put(konfigurasi.KEY_MHS_NAMA,nama);
                params.put(konfigurasi.KEY_MHS_JURUSAN,jurusan);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(konfigurasi.URL_TAMBAH, params);
                return res;
            }
        }

        AddEmployee ae = new AddEmployee();
        ae.execute();
    }
}