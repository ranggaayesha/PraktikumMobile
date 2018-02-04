package com.httpsinauyo.studycase_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText Menu;
    private EditText FoodQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void eatbus (View view){
        Intent intent = new Intent(this, SecondActivity.class);
        Menu = (EditText) findViewById(R.id.Menu);
        String menu_makanan = Menu.getText().toString();
        FoodQ = (EditText) findViewById(R.id.FoodQ);
        String jumlah_porsi = FoodQ.getText().toString();
        intent.putExtra("restaurant","Eatbus");
        intent.putExtra("menuMakanan", menu_makanan);
        intent.putExtra("Q",jumlah_porsi);
        intent.putExtra("Cost","50000");
        startActivity(intent);
    }

    public void abnormal (View view){
        Intent intent = new Intent(this, SecondActivity.class);
        Menu = (EditText) findViewById(R.id.Menu);
        String menu_makanan = Menu.getText().toString();
        FoodQ = (EditText) findViewById(R.id.FoodQ);
        String jumlah_porsi = FoodQ.getText().toString();
        intent.putExtra("restaurant","Abnormal");
        intent.putExtra("menuMakanan", menu_makanan);
        intent.putExtra("Q",jumlah_porsi);
        intent.putExtra("Cost","30000");
        startActivity(intent);
    }
}
