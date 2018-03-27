package com.example.angeles.labapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    static final int SEND_MESSAGE = 1;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        CredentialManage nueva = new CredentialManage();
        if (!nueva.verificarCredenciales(this)) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.putExtra(EXTRA_MESSAGE,"Sent!");
            //iniciaractividad solo si no existe anteriormente
            startActivityForResult(intent,SEND_MESSAGE);
        }
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
                TextView textViewmail = findViewById(R.id.Nombreusuario);
                textViewmail.setText(email);
                //TextView textViewpass = findViewById(R.id.textViewPassword);
                //textViewpass.setText(password);

                CredentialManage nueva = new CredentialManage();
                nueva.guardarCredenciales(this,email,password);



            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Fragment fragment = null;
        Boolean fragmentactive=false;

        int id = item.getItemId();

        if (id == R.id.db) {
            fragmentactive=true;
            fragment=new FormFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.framenew,fragment).addToBackStack("null").commit();

        } else if (id == R.id.event) {
            fragment=new ListFragment();
            fragmentactive=true;
            getSupportFragmentManager().beginTransaction().replace(R.id.framenew,fragment).addToBackStack("null").commit();

            //}// else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.search) {
            fragment=new ResumeFragment();
            fragmentactive=true;
            getSupportFragmentManager().beginTransaction().replace(R.id.framenew,fragment).addToBackStack("null").commit();

        } else if (id == R.id.logout) {
            CredentialManage nueva = new CredentialManage();
            nueva.borrarCredenciales(this);
            Intent intent = new Intent(this, LoginActivity.class);
            intent.putExtra(EXTRA_MESSAGE,"Sent!");
            //iniciaractividad solo si no existe anteriormente
            startActivityForResult(intent,SEND_MESSAGE);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

