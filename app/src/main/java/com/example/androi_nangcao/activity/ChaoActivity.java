package com.example.androi_nangcao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androi_nangcao.R;

public class ChaoActivity extends AppCompatActivity {
    private final int SPLASH_DISPLAY_DURATION = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chao);

        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(ChaoActivity.this, login.class);
                ChaoActivity.this.startActivity(mainIntent);
                ChaoActivity.this.finish();
            }
        },SPLASH_DISPLAY_DURATION );
    }
}