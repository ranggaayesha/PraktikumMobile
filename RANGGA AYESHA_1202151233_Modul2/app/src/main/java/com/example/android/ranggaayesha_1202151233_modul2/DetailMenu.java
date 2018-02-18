package com.example.android.ranggaayesha_1202151233_modul2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailMenu extends AppCompatActivity {

    //pembuatan object baru
    TextView tv_food, tv_price;
    ImageView iv_photo;

    //method berikut akan dijalankan saat aktifitas dimulai
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);
        Intent intent = getIntent(); //mendapatkan data dari aktifitas lain
        String food = intent.getStringExtra("food");
        Integer price = intent.getIntExtra("price",0);
        Integer photo = intent.getIntExtra("photo",0);

        Log.d("getIntExtra", ""+price+photo);

        tv_food = (TextView)findViewById(R.id.tv_detailFood);
        tv_price = (TextView)findViewById(R.id.tv_detailPrice);
        iv_photo = (ImageView)findViewById(R.id.iv_detailPhoto);

        tv_food.setText(food);
        tv_price.setText("Rp. "+price);
        iv_photo.setImageResource(photo);
    }
}
