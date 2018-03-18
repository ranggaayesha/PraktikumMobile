package com.example.android.ranggaayesha_1202151233_studycase4;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;

public class GambarActivity extends AppCompatActivity {
    //Deklarasi private variable
    private ImageView downloadedImage;
    private ProgressDialog mProgressDialog;
    private EditText linkUrl;
    private Button imageDownloaderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gambar);

        //Mempersiapkan fungsi yang akan digunakan nantinya
        imageDownloaderButton = (Button) findViewById(R.id.button_startAsyncTask);
        downloadedImage = (ImageView) findViewById(R.id.ImageView);
        linkUrl = (EditText)findViewById(R.id.urlText);

        //Eksekusi ketika button diklik
        imageDownloaderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String downloadUrl = linkUrl.getText().toString();
                if(downloadUrl.isEmpty()){
                    //Menampilkan toast ketika button diklik namun edit text url kosong
                    Toast.makeText(GambarActivity.this,"Masukkan URL gambar terlebih dahulu",Toast.LENGTH_SHORT).show();
                }else {
                    // Execute DownloadImage AsyncTask
                    new ImageDownloader().execute(downloadUrl);
                }
            }
        });
    }
    private class ImageDownloader extends AsyncTask<String, Void, Bitmap> {

        //Dipanggil di thread UI sebelum tugas dijalankan
        //Biasa digunakan untuk mempersiapkan tujuan, dengan menampilkan progress bar
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Membuat ProgressDialog
            mProgressDialog = new ProgressDialog(GambarActivity.this);
            //Pesan yang akan muncul saat proses
            mProgressDialog.setTitle("Search Image");
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            //Menampilkan Progressnya
            mProgressDialog.show();
        }

        @Override
        protected Bitmap doInBackground(String... URL) {

            String imageURL = URL[0];

            Bitmap bitmap = null;
            try {
                //Mendownload gambar berdasarkan link yang dimasukkan
                InputStream input = new java.net.URL(imageURL).openStream();
                //menDecode Bitmap
                bitmap = BitmapFactory.decodeStream(input);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            //Memasang Gambar yang sebelumnya di unduh ke ImageView yang sudah disiapkan di line 31
            downloadedImage.setImageBitmap(result);
            //Menutup ProgressDialog yang sebelumnya ditampilkan
            mProgressDialog.dismiss();
        }
    }
}