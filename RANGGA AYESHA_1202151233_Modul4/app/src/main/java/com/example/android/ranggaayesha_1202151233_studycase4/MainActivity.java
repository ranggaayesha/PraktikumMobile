package com.example.android.ranggaayesha_1202151233_studycase4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Akan mengalihkan ke aktifitas Daftar Mahasiswa
    public void tampilNama(View view) {
        Intent i = new Intent(getApplicationContext(),MahasiswaActivity.class);
        startActivity(i);
    }

    //Akan mengalihkan ke aktifitas Penampil Gambar
    public void tampilGambar(View view) {
        Intent i = new Intent(getApplicationContext(),GambarActivity.class);
        startActivity(i);
    }
}
