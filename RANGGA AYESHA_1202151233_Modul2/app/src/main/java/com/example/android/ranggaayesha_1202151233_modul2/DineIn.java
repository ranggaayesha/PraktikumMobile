package com.example.android.ranggaayesha_1202151233_modul2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class DineIn extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener{

    //method berikut akan dijalankan saat aktifitas dimulai
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dine_in);
        //Membuat fidget spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner_table);

        //Buat ArrayAdapter menggunakan array string dan layout fidget spinner default.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tables_array, android.R.layout.simple_spinner_item);
        //Menentukan letak saat daftar pilihan muncul
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        // Terapkan adaptor ke spinner
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    // method untuk mengarahkan ke aktivitas selanjutnya
    public void onClickOrder(View view) {
        Intent intent = new Intent(this,Menu.class);
        startActivity(intent);
    }
}
