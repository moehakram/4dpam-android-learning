package com.example.a213049_muhakram;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Locale;

public class bayar extends AppCompatActivity {
    private RelativeLayout popupLayout;


    private LinearLayout sc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bayar);



        final int[] hrga = {getIntent().getIntExtra("hargafix", 20000), 15000, 3000};
        final int Total = hrga[0] + hrga[1] + hrga[2];

        int[] viewIds = {R.id.harganya, R.id.ongkir, R.id.pajak, R.id.totbayar, R.id.tuntas};
        int[] values = {hrga[0], hrga[1], hrga[2], Total, Total};

        for (int i = 0; i < viewIds.length; i++) {
            format(findViewById(viewIds[i]), values[i]);
        }


        View p = getLayoutInflater().inflate(R.layout.up_detail_bayar,null);
        LinearLayout openButton = findViewById(R.id.lihatperincian);
        // Set listener untuk button close
        openButton.setOnClickListener(a -> showPopup(p.findViewById(R.id.popup_layout)));

        CardView closeButton = p.findViewById(R.id.close_button);
        closeButton.setOnClickListener(a -> hidePopup(p.findViewById(R.id.popup_layout)));

        CardView button = findViewById(R.id.ubahcttn);
        TextView catatan = findViewById(R.id.catatan);
        button.setOnClickListener(v -> ubahcatatan(catatan));

        CardView button1 = findViewById(R.id.ubahalamat);
        TextView alamat = findViewById(R.id.alamat);
        button1.setOnClickListener(v -> ubahalmat(alamat));

        CardView button2 = findViewById(R.id.konfirmasi);
        button2.setOnClickListener(v -> konfirmasi());


    }
    private void tampilkanRincianPesanan(Intent intent) {
        int totalHarga = intent.getIntExtra("hargafix", 0);
        int[] jumlahPesanan = intent.getIntArrayExtra("jumlah_pesanan");
        String[] namaMenu = intent.getStringArrayExtra("nama_menu");

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View popup = getLayoutInflater().inflate(R.layout.up_detail_bayar, null);
        builder.setView(popup);
        AlertDialog dialog = builder.create();

        TextView textViewRincian = popup.findViewById(R.id.text_rincian);
  /*      StringBuilder sb = new StringBuilder();
        sb.append("Rincian Pesanan:\n");
        for (int i = 0; i < jumlahPesanan.length; i++) {
            int jumlah = jumlahPesanan[i];
            if (jumlah > 0) {
                sb.append(namaMenu[i]).append(": ").append(jumlah).append("\n");
            }
        }*/
        textViewRincian.setText("fghjk");

        TextView textViewHarga = popup.findViewById(R.id.d_harga);
        textViewHarga.setText(String.valueOf(totalHarga));

        TextView textViewTotalPembayaran = popup.findViewById(R.id.d_totbayar);
        textViewTotalPembayaran.setText("Rp" + String.valueOf(totalHarga));


       CardView closeButton = popup.findViewById(R.id.close_button);


        closeButton.setOnClickListener(a -> dialog.dismiss());


        dialog.show();
    }





    private void format(TextView var, int total){
        String f = String.format(Locale.US,"%,d", total).replace(',', '.');
        var.setText(f);
        }
    private void konfirmasi() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Terima kasih!");
        builder.setMessage("Pesanan sudah dikonfirmasi.");

        builder.setPositiveButton("OK", (dialog, which) -> {
            // Tindakan yang ingin Anda lakukan setelah tombol OK ditekan
            dialog.dismiss(); // Menutup dialog setelah tombol OK ditekan
        });

        // Menampilkan AlertDialog
        builder.show();
    }

    private void ubahcatatan(final TextView textView) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Ubah Catatan");

        // Membuat EditText di dalam AlertDialog
        final EditText editText = new EditText(this);
        builder.setView(editText);

        // Menambahkan tombol "Ubah" di dalam AlertDialog
        builder.setPositiveButton("Ubah", (dialog, which) -> {
            String newValue = editText.getText().toString();
            textView.setText(newValue);
        });

        // Menambahkan tombol "Batal" di dalam AlertDialog
        builder.setNegativeButton("Batal", (dialog, which) -> dialog.cancel());

        // Menampilkan AlertDialog
        builder.show();
    }
    private void ubahalmat(final TextView textView) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Ubah Alamat");

        // Membuat EditText di dalam AlertDialog
        final EditText editText = new EditText(this);
        builder.setView(editText);

        // Menambahkan tombol "Ubah" di dalam AlertDialog
        builder.setPositiveButton("Ubah", (dialog, which) -> {
            String newValue = editText.getText().toString();
            textView.setText(newValue);
        });

        // Menambahkan tombol "Batal" di dalam AlertDialog
        builder.setNegativeButton("Batal", (dialog, which) -> dialog.cancel());

        // Menampilkan AlertDialog
        builder.show();
    }

    private void showPopup(RelativeLayout popupLayout) {

        Animation slideUpAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_up);

        // Tampilkan pop-up layout setelah animasi slide up selesai
        slideUpAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                sc.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // Set visibilitas pop-up layout menjadi visible setelah animasi slide up selesai
                popupLayout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });
        // Load animasi slide up dari file xml
        popupLayout.startAnimation(slideUpAnimation);
        // Mulai animasi slide up pada pop-up layout


    }

    private void hidePopup(RelativeLayout popupLayout) {

        // Load animasi slide down dari file xml
        Animation slideDownAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_down);

        // Tambahkan listener untuk mengetahui kapan animasi telah selesai
        slideDownAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                sc.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // Sembunyikan pop-up layout saat animasi slide down telah selesai
                popupLayout.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        // Mulai animasi slide down pada pop-up layout
        popupLayout.startAnimation(slideDownAnimation);

    }



}