package com.example.android.ranggaayesha_1202151233_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    //menginisialkan untuk object seperti gambar dan tombol
    ImageView imgLogo, imgBattery;
    TextView textTitle, textLiter;
    ImageButton btnMinus, btnPlus;

    //Membuat variabel liter untuk menampung angka 0-6 dimana 0 awal dan 6 saat full
    int liter;

    //Menjalankan aktifitas dan mendapatkan data dari intent
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Mengambil intent dari menu list
        Intent intent = getIntent();

        imgLogo = findViewById(R.id.imageView);
        imgBattery = findViewById(R.id.imageBottle);
        textTitle = findViewById(R.id.textJudul);
        textLiter = findViewById(R.id.textLiter);
        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);

        int image = intent.getIntExtra("image", 0);
        imgLogo.setImageResource(image);
        textTitle.setText(intent.getStringExtra("title"));

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                liter--;
                update_gambar(liter);
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                liter++;
                update_gambar(liter);
            }
        });
    }

    //Method untuk pengisian air
    private void update_gambar(int liter) {
        switch (liter) {
            case 0:
                btnMinus.setEnabled(false);
                btnPlus.setEnabled(true);

                imgBattery.setImageResource(R.drawable.ic_battery_20);
                textLiter.setText(String.valueOf(liter) + "L");

                Toast.makeText(getApplicationContext(),
                        "Air Sedikit",
                        Toast.LENGTH_SHORT)
                        .show();
                break;
            case 1:
                btnMinus.setEnabled(true);
                btnPlus.setEnabled(true);

                imgBattery.setImageResource(R.drawable.ic_battery_30);
                textLiter.setText(String.valueOf(liter) + "L");
                break;
            case 2:
                btnMinus.setEnabled(true);
                btnPlus.setEnabled(true);

                imgBattery.setImageResource(R.drawable.ic_battery_50);
                textLiter.setText(String.valueOf(liter) + "L");
                break;
            case 3:
                btnMinus.setEnabled(true);
                btnPlus.setEnabled(true);

                imgBattery.setImageResource(R.drawable.ic_battery_60);
                textLiter.setText(String.valueOf(liter) + "L");
                break;
            case 4:
                btnMinus.setEnabled(true);
                btnPlus.setEnabled(true);

                imgBattery.setImageResource(R.drawable.ic_battery_80);
                textLiter.setText(String.valueOf(liter) + "L");
                break;
            case 5:
                btnMinus.setEnabled(true);
                btnPlus.setEnabled(true);

                imgBattery.setImageResource(R.drawable.ic_battery_90);
                textLiter.setText(String.valueOf(liter) + "L");
                break;
            case 6:
                btnPlus.setEnabled(false);
                btnMinus.setEnabled(true);

                imgBattery.setImageResource(R.drawable.ic_battery_full);
                textLiter.setText(String.valueOf(liter) + "L");

                Toast.makeText(getApplicationContext(),
                        "Air Sudah Full",
                        Toast.LENGTH_SHORT)
                        .show();
                break;
        }
    }
}
