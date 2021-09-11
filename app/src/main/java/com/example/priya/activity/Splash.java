package com.example.priya.activity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.priya.R;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //checking internet connection
        ConnectivityManager manager=(ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork=manager.getActiveNetworkInfo();
        if(null!=activeNetwork) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
                Toast.makeText(this, "wifi enabled", Toast.LENGTH_LONG).show();
            else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
                Toast.makeText(this, "data network", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "no internet", Toast.LENGTH_LONG).show();
        }


        //splash screen
        Handler handler =new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },2500);
    }
}