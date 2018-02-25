package com.example.android.ranggaayesha_1202151233_modul3;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {

    //method berikut akan dijalankan saat aktifitas dimulai
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hilangin title, jadi fullscreen
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);
        //Berfungsi untuk menampilkan nama dan nim kita dalam bentuk popup
        Toast.makeText(this, "RANGGA AYESHA_1202151233", Toast.LENGTH_SHORT).show();

        // handle splash screen
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000L); //hitungannya 1000L = 1 detik, jadi untuk pemasangan 3000L = 3 detik
    }
}
