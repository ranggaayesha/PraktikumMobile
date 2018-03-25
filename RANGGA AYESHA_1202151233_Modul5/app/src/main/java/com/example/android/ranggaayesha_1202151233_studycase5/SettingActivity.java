package com.example.android.ranggaayesha_1202151233_studycase5;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SettingActivity extends AppCompatActivity {
    //Deklarasi variabel
    TextView shapeclr;
    int colorid;
    AlertDialog.Builder alert;
    SharedPreferences.Editor spe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        setTitle("Pengaturan");

        //Membuat alert dialog baru bernama alert
        alert = new AlertDialog.Builder(this);

        //Menginisialisasi shared preference
        SharedPreferences sharedP = getApplicationContext().getSharedPreferences("Preferences", 0);
        spe = sharedP.edit();
        colorid = sharedP.getInt("Colourground", R.color.w);
        //Mengakses text view pada layout
        shapeclr = findViewById(R.id.shapecolor);
        //Set shape color dengan color id ditentukan
        shapeclr.setText(getShapeColor(colorid));
    }

    //Bila tombol back ditekan
    @Override
    public void onBackPressed() {
        //Intent baru dari pengaturan menuju list to do
        Intent intent = new Intent(SettingActivity.this, ListToDoActivity.class);
        //Memulai intent
        startActivity(intent);
        //Menutup activity setelah berhasil dikerjakan
        finish();
    }

    //Method dijalankan ketika pilihan pada menu dipilih
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            //Menjalankan method onbackpressed
            this.onBackPressed();
        }
        return true;
    }

    //Mendapatkan string warna yang akan digunakan untuk mengubah shape color
    public String getShapeColor(int i){
        if (i==R.color.r){
            return "Red";
        }else if (i==R.color.g){
            return "Green";
        }else if (i==R.color.b){
            return "Blue";
        }else{
            return "Default";
        }
    }

    //Mendapatkan id dari warna yang akan digunakan
    public int getColorid(int i){
        if (i==R.color.r){
            return R.id.red;
        }else if (i==R.color.g){
            return R.id.green;
        }else if (i==R.color.b){
            return R.id.blue;
        }else{
            return R.id.white;
        }
    }

    public void choosecolor(View view) {
        //Set title dari alert dialog menjadi Shape Color
        alert.setTitle("Shape Color");
        //Membuat view baru
        View view1 = getLayoutInflater().inflate(R.layout.color_setting, null);
        //Menampilkan view yang telah dibuat
        alert.setView(view1);

        //Mengakses radio group pada layout
        final RadioGroup radG = view1.findViewById(R.id.radiocolor);
        radG.check(getColorid(colorid));

        //Ketika menekan Ok pada alert dialog
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Mendapatkan id radio button yang di pilih
                int a = radG.getCheckedRadioButtonId();
                switch (a){
                    case R.id.red:
                        colorid = R.color.r;
                        break;
                    case R.id.green:
                        colorid = R.color.g;
                        break;
                    case R.id.blue:
                        colorid = R.color.b;
                        break;
                    case R.id.white:
                        colorid = R.color.w;
                        break;
                }
                //Set shape color menjadi color id yang dipilih
                shapeclr.setText(getShapeColor(colorid));
                //Menaruh shared preference
                spe.putInt("Colourground", colorid);
                //Commit shared preference
                spe.commit();
            }
        });

        //Ketika menekan Cancel pada alert dialog
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        //Membuat dan menampilkan alert dialog
        alert.create().show();
    }
}