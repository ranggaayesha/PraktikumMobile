package com.httpsinauyo.studycase_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private TextView tempat;
    private TextView menu;
    private TextView jumlah;
    private TextView harga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();

        String rName = intent.getStringExtra("restaurant");
        String fName = intent.getStringExtra("menuMakanan");
        String quantity = intent.getStringExtra("Q");
        String fCost = intent.getStringExtra("Cost");
        int hrg = Integer.valueOf(fCost)*Integer.valueOf(quantity);

        tempat = (TextView) findViewById(R.id.displayRestaurant);
        tempat.setText(rName);

        menu = (TextView) findViewById(R.id.displayMenu);
        menu.setText(fName);

        jumlah = (TextView) findViewById(R.id.displayFoodQ);
        jumlah.setText(quantity);

        harga = (TextView) findViewById(R.id.displayCost);
        harga.setText(String.valueOf(hrg));

        if(hrg > 65000){
            Toast toast = Toast.makeText(this, "Uang kamu tidak cukup, cari tempat lain;", Toast.LENGTH_LONG);
            toast.show();
        } else {
            Toast toast = Toast.makeText(this, "Uang kamu cukup;", Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
