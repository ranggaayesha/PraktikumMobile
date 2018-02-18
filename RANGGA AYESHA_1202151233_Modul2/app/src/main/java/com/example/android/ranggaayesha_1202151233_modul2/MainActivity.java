package com.example.android.ranggaayesha_1202151233_modul2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //method berikut akan dijalankan saat aktifitas dimulai
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickOrder(View view) {
        //Akan menampilkan toast bila klik Dine In
        if (((RadioButton)findViewById(R.id.rbt_DineIn)).isChecked()){
            Intent intent = new Intent(this, DineIn.class);
            Toast.makeText(this, "Dine In", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        //Akan menampilkan toast bila klik Take Away
        }else if (((RadioButton)findViewById(R.id.rbt_TakeAway)).isChecked()){
            Intent intent = new Intent(this, TakeAway.class);
            Toast.makeText(this, "Take Away", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }else{
            Toast.makeText(this,"Anda belum memilih order",Toast.LENGTH_SHORT).show();
        }
    }
}
