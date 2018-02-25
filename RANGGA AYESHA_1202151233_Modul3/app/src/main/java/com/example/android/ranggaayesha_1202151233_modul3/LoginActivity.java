package com.example.android.ranggaayesha_1202151233_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText inputUsername, inputPassword;
    Button btnLogin;

    //method berikut akan dijalankan saat aktifitas dimulai
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputUsername = findViewById(R.id.inputUsername);
        inputPassword = findViewById(R.id.inputPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }

    //Persyaratan login
    public void onLogin(View view) {
        if ( inputUsername.getText().toString().equals("EAD") &&
                inputPassword.getText().toString().equals("MOBILE") ) {
            //Akan menampilkan toast bila login benar
            Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        } else {
            //Akan menampilkan toast bila salah
            Toast.makeText(this, "Maaf username/password yang anda masukkan salah:(", Toast.LENGTH_SHORT).show();
            //Akan mengosongkan kolom
            inputUsername.setText("");
            inputPassword.setText("");
        }
    }
}
