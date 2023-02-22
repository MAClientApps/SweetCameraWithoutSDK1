package com.camapp.sweetme.act;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.camapp.sweetme.R;

public class SweetSplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitysweet_splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Write whatever to want to do after delay specified (1 sec)
                Intent intent = new Intent(SweetSplashActivity.this, SweetMainAct.class);

                startActivity(intent);
                finish();
            }
        }, 1000);

    }
}