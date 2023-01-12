package com.example.responsi0669.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.responsi0669.R;
import com.example.responsi0669.utils.PreferencesHelper;

public class SplashActivity extends AppCompatActivity {

    public static final String TAG = "SplashScreen";
    PreferencesHelper preferencesHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        preferencesHelper = PreferencesHelper.getInstance(getApplicationContext());

        if (!preferencesHelper.isLogin()) {
            Intent homeIntent = new Intent(SplashActivity.this, LoginActivity.class);
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK );
            startActivity(homeIntent);
        } else {
            Intent loginIntent = new Intent(SplashActivity.this, HomeActivity.class);
            loginIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK );
            startActivity(loginIntent);
        }

//        int splashInterval = 3000;
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                if (!preferencesHelper.isLogin()) {
//                    Intent homeIntent = new Intent(SplashActivity.this, LoginActivity.class);
//                    homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK );
//                    startActivity(homeIntent);
//                } else {
//                    Intent loginIntent = new Intent(SplashActivity.this, HomeActivity.class);
//                    loginIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK );
//                    startActivity(loginIntent);
//                }
//            }
//        }, splashInterval);
    }
}