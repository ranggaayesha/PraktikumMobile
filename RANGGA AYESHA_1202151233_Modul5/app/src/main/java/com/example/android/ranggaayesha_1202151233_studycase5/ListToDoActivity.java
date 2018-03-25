package com.example.android.ranggaayesha_1202151233_studycase5;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class ListToDoActivity extends AppCompatActivity {
    //Deklarasi variabel
    Database dtbase;
    RecyclerView rv;
    Adapter adapter;
    ArrayList<AddDataActivity> datalist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_to_do);
        //Mengubah kalimat di action bar
        setTitle("My ToDo List");

        //Mengakses recyclerview yang ada pada layout
        rv = findViewById(R.id.recview);
        //Membuat araylist baru
        datalist = new ArrayList<>();
        //Membuat database baru
        dtbase = new Database(this);
        //Memanggil method readdata
        dtbase.readdata(datalist);

        //Menginisialisasi shared preference
        SharedPreferences sharedP = this.getApplicationContext().getSharedPreferences("Preferences", 0);
        int color = sharedP.getInt("Colourground", R.color.w);

        //Membuat adapter baru
        adapter = new Adapter(this,datalist, color);
        //Mengatur ukuran setelah data dibuat atau dihapus
        rv.setHasFixedSize(true);
        //Menampilkan layout linear
        rv.setLayoutManager(new LinearLayoutManager(this));
        //Menginisiasi adapter untuk recycler view
        rv.setAdapter(adapter);

        //Menjalankan method hapus data pada list to do
        swiftDel();
    }

    //Membuat method untuk menghapus data dari list yang ada saat dilakukan penggeseran / swiping
    public void swiftDel(){
        //Membuat touch helper baru untuk recycler view
        ItemTouchHelper.SimpleCallback touchcall = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                AddDataActivity current = adapter.getData(position);
                //Menghapus data saat ditarik ke kanan
                if(direction==ItemTouchHelper.RIGHT){
                    //Menghapus data berdasarkan Primary key yang dimiliki object yang di swipe
                    if(dtbase.removedata(current.getTodo())){
                        //Menghapus data
                        adapter.deleteData(position);
                        //Membuat snack bar dan pemberitahuan bahwa item sudah terhapus dengan durasi 1 sekon
                        Snackbar.make(findViewById(R.id.coor), "List Deleted", 1000).show();
                    }
                }
            }
        };
        //Menentukan itemtouchhelper untuk recycler view
        ItemTouchHelper touchhelp = new ItemTouchHelper(touchcall);
        touchhelp.attachToRecyclerView(rv);
    }
    //Ketika menu pada activity di buat
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        return true;
    }

    //Method dijalankan ketika item di pilih
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Mendapatkan id dari item yang
        int id = item.getItemId();
        //Apabila item yang dipilih adalah setting
        if (id==R.id.action_settings){
            //Membuat intent baru dari list to do ke pengaturan
            Intent intent = new Intent(ListToDoActivity.this, SettingActivity.class);
            //Memulai intent
            startActivity(intent);
            //Menutup activity setelah berhasil dilakukan
            finish();
        }
        return true;
    }

    //Method dijalankan ketika tombol add di klik
    public void add(View view) {
        //Intent dari list to do ke add to do
        Intent intent = new Intent(ListToDoActivity.this, AddToDoActivity.class);
        //Memulai intent
        startActivity(intent);
    }
}