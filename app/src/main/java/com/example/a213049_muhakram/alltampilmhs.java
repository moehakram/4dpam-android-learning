package com.example.a213049_muhakram;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class alltampilmhs extends AppCompatActivity {

    private ListView listView;
    private String JSON_STRING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alltampilmhs);

        listView = findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(alltampilmhs.this, tampilmhs.class);
                HashMap<String, String> map = (HashMap) adapterView.getItemAtPosition(i);
                String mhsNim = map.get(konfigurasi.TAG_NIM);
                intent.putExtra(konfigurasi.MHS_NIM, mhsNim);
                startActivity(intent);
            }
        });
        getJSON();
    }

    private void showMhs() {
        JSONObject jsonObject;
        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);

            for (int i = 0; i < result.length(); i++) {
                JSONObject jo = result.getJSONObject(i);
                String nim = jo.getString(konfigurasi.TAG_NIM);
                String nama = jo.getString(konfigurasi.TAG_NAMA);
                String jurusan = jo.getString(konfigurasi.TAG_JURUSAN);

                HashMap<String, String> employees = new HashMap<>();
                employees.put(konfigurasi.TAG_NIM, nim);
                employees.put(konfigurasi.TAG_NAMA, nama);
                employees.put(konfigurasi.TAG_JURUSAN, jurusan);
                list.add(employees);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                alltampilmhs.this, list, R.layout.list_item,
                new String[]{konfigurasi.TAG_NIM, konfigurasi.TAG_NAMA, konfigurasi.TAG_JURUSAN},
                new int[]{R.id.nim, R.id.nama, R.id.jurusan});

        listView.setAdapter(adapter);
    }

    private void getJSON() {
        class GetJSON extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(alltampilmhs.this, "Mengambil Data", "Mohon Tunggu...", false, false);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_ALLTAMPILMHS);
                return s;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showMhs();
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }
}
