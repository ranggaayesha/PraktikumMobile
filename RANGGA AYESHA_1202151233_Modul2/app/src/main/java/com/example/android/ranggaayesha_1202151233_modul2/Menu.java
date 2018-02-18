package com.example.android.ranggaayesha_1202151233_modul2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;

public class Menu extends AppCompatActivity {

    // untuk deklarasi objek
    private final LinkedList<String> foods = new LinkedList<>();
    private final LinkedList<Integer> priceses = new LinkedList<>();
    private final LinkedList<Integer> photos = new LinkedList<>();
    private int mCount = 0;

    private RecyclerView mRecyclerView;
    private MenuAdapter mAdapter;

    //method berikut akan dijalankan saat aktifitas dimulai
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        dummiesData();
        //akan mendapatkan handle untuk recyclerview
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        //membuat adapter dan memanggil data yang akan ditampilkan
        mAdapter = new MenuAdapter(this, foods, priceses, photos);
        //menghubungkan adaptor dengan RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        //memberikan RecyclerView sebagai pengelola letak default.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void dummiesData(){
        for (int i = 0;i < 1; i++){
            //Membuat data untuk ditampilkan dan disimpan (daftar menu)
            foods.add("Pizza Ayam");
            foods.add("Rendang Ayam");
            foods.add("Paket Ternak 1");
            foods.add("Paket Ternak 2");
            foods.add("Paket Sundulin 1");
            foods.add("Paket Sundulin 2");
            foods.add("Burger Ayam aja");
            foods.add("Burger Ayam Jumbo");
            foods.add("Ayam Fresh");

            //Membuat data untuk ditampilkan dan disimpan (Harga dari menu)
            priceses.add(25000);
            priceses.add(24999);
            priceses.add(30000);
            priceses.add(35000);
            priceses.add(20000);
            priceses.add(21000);
            priceses.add(15000);
            priceses.add(19000);
            priceses.add(40000);

            //Membuat data untuk ditampilkan dan disimpan (foto preview dari menu), gambar dari drawable
            photos.add(R.drawable.ayamitali);
            photos.add(R.drawable.ayampadang);
            photos.add(R.drawable.ternak1);
            photos.add(R.drawable.ternak2);
            photos.add(R.drawable.sundulin1);
            photos.add(R.drawable.sundulin2);
            photos.add(R.drawable.ayamroti);
            photos.add(R.drawable.ayamrotigede);
            photos.add(R.drawable.ayamhidup);
        }
    }
}
