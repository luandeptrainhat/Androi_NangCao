package com.example.androi_nangcao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androi_nangcao.R;

public class Home extends AppCompatActivity {
    ImageView imghoctap, imgmap, imgnew , imgSocial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        imghoctap = findViewById(R.id.imghoctap);
        imgmap = findViewById(R.id.imgmap);
        imgnew = findViewById(R.id.imgnew);
        imgSocial = findViewById(R.id.imgSocial);


        imghoctap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(Home.this, "alo", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Home.this, Quanli_khoahoc.class);
                startActivity(intent);
            }
        });
        imgmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this,BanDoActivity.class));
            }
        });
        imgnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this,News.class));
            }
        });
    }
}