package com.example.android.ranggaayesha_1202151233_modul3;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;

public class MenuActivity extends AppCompatActivity {

    //Deklarasi objek
    private final LinkedList<String> menuJudul = new LinkedList<>();
    private final LinkedList<String> menuDesc = new LinkedList<>();
    private final LinkedList<Integer> menuImage = new LinkedList<>();
    private int mCount = 0;

    private RecyclerView mRecyclerView;
    private MenuAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Memberikan nama produk
        menuJudul.addLast("Ades");
        menuJudul.addLast("Amidis");
        menuJudul.addLast("Aqua");
        menuJudul.addLast("Cleo");
        menuJudul.addLast("Club");
        menuJudul.addLast("Equil");
        menuJudul.addLast("Evian");
        menuJudul.addLast("Leminerale");
        menuJudul.addLast("Nestle");
        menuJudul.addLast("Pristine");
        menuJudul.addLast("Vit");

        //Memberikan deskripsi singkat dari produk
        menuDesc.addLast("Ini air minum ramah lingkungan, Ades");
        menuDesc.addLast("Ini air minum mahasiswa, Amidis");
        menuDesc.addLast("Ini air minum pasaran, Aqua");
        menuDesc.addLast("Ini air minum underrated, Cleo");
        menuDesc.addLast("Ini air minum pilihan terakhir Club");
        menuDesc.addLast("Ini air minum haram katanya, Equil");
        menuDesc.addLast("Ini air minum baru denger, Evian");
        menuDesc.addLast("Ini air minum murah, Leminerale");
        menuDesc.addLast("Ini air minum 25% kantoran, Nestle");
        menuDesc.addLast("Ini air minum baru denger (2), Pristine");
        menuDesc.addLast("Ini air minum fit, Vit");

        //Menambah file gambar
        menuImage.addLast(R.drawable.ades);
        menuImage.addLast(R.drawable.amidis);
        menuImage.addLast(R.drawable.aqua);
        menuImage.addLast(R.drawable.cleo);
        menuImage.addLast(R.drawable.club);
        menuImage.addLast(R.drawable.equil);
        menuImage.addLast(R.drawable.evian);
        menuImage.addLast(R.drawable.leminerale);
        menuImage.addLast(R.drawable.nestle);
        menuImage.addLast(R.drawable.pristine);
        menuImage.addLast(R.drawable.vit);

        //akan mendapatkan handle untuk recyclerview
        mRecyclerView = findViewById(R.id.recyclerView);
        //membuat adapter dan memanggil data yang akan ditampilkan
        mAdapter = new MenuAdapter(this, menuJudul, menuDesc, menuImage);
        //menghubungkan adaptor dengan RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        //memberikan RecyclerView sebagai pengelola letak default.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //setlayoutmanager untuk recyclerview
        if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            //Mengubah format menjadi 2 kolom bila tampilan landscape
            mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        }
        else{
            //Mengubah format menjadi Linear untuk tampilan Portrait
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
    }
}