package com.example.android.ranggaayesha_1202151233_studycase5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddToDoActivity extends AppCompatActivity {
    //Deklarasi variabel
    EditText ToDo, Description, Priority;
    Database dtbase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do);
        //set title menjadi add to do
        setTitle("Add To Do");

        //Mempersiapkan fungsi yang akan digunakan nantinya
        ToDo = (EditText) findViewById(R.id.editTodo);
        Description = (EditText) findViewById(R.id.editDesc);
        Priority = (EditText) findViewById(R.id.editPriority);
        dtbase = new Database(this);
    }

    @Override
    public void onBackPressed() {
        //Intent untuk pindah dari add to do menuju list to do, saat tombol back ditekan
        Intent intent = new Intent(AddToDoActivity.this, ListToDoActivity.class);
        //Memulai intent
        startActivity(intent);
        //Activity ditutup setelah intent dijalankan
        this.finish();
    }

    //Method yang dijalanan ketika fungsi tambah todo di klik
    public void tambah(View view) {
        //Pemisahan antara kolom yang diisi dan tidak
        if (dtbase.inputdata(new AddDataActivity(ToDo.getText().toString(), Description.getText().toString(), Priority.getText().toString()))){
            //maka akan menampilkan toast baha data berhasil di tambahkan ke dalam list
            Toast.makeText(this, "New list Added", Toast.LENGTH_SHORT).show();
            //Pergi ke activity list to do
            startActivity(new Intent(AddToDoActivity.this, ListToDoActivity.class));
            //Menutup activity setelah berhasil dilakukan
            this.finish();
        }else {
            //Bila kolom tidak terisi
            Toast.makeText(this, "List invalid", Toast.LENGTH_SHORT).show();
            //Mengosongkan kolom
            ToDo.setText(null);
            Description.setText(null);
            Priority.setText(null);
        }
    }
}
