package com.example.android.ranggaayesha_1202151233_modul2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class Splash extends Activity {

    //method berikut akan dijalankan saat aktifitas dimulai
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Toast.makeText(this, "RANGGA AYESHA_1202151233", Toast.LENGTH_SHORT).show(); //Berfungsi untuk menampilkan nama dan nim kita dalam bentuk popup
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            // method untuk mengarahkan ke aktivitas selanjutnya
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        }, 5000L); //hitungannya 1000L = 1 detik, jadi untuk pemasangan 5000L = 5 detik
    }
}
