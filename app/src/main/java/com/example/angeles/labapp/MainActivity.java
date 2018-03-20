package com.example.angeles.labapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    static final int SEND_MESSAGE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CredentialManage nueva = new CredentialManage();
        if (!nueva.verificarCredenciales(this)) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.putExtra(EXTRA_MESSAGE,"Sent!");
            //iniciaractividad solo si no existe anteriormente
            startActivityForResult(intent,SEND_MESSAGE);
        }
    }
    public void logOut(View view) {
        CredentialManage nueva = new CredentialManage();
        nueva.borrarCredenciales(this);
        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra(EXTRA_MESSAGE,"Sent!");
        //iniciaractividad solo si no existe anteriormente
        startActivityForResult(intent,SEND_MESSAGE);

    }
    public void onBackPressed(){
        setResult(RESULT_CANCELED);
        finish();
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == SEND_MESSAGE) {

            if (resultCode == RESULT_OK) {

                String email = data.getStringExtra("email_devuelto");
                String password = data.getStringExtra("password_devuelto");
                TextView textViewmail = findViewById(R.id.textViewNombre);
                textViewmail.setText(email);
                TextView textViewpass = findViewById(R.id.textViewPassword);
                textViewpass.setText(password);

                CredentialManage nueva = new CredentialManage();
                nueva.guardarCredenciales(this,email,password);



            }
        }
    }
}

