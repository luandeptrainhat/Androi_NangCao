package com.example.androi_nangcao.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.androi_nangcao.R;

public class Quanli_khoahoc extends AppCompatActivity {
    LinearLayout dangki, dadangki;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanli_khoahoc);

      dangki= findViewById(R.id.dangki);
      dadangki= findViewById(R.id.dadangki);

      dangki.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              startActivity(new Intent(Quanli_khoahoc.this,dangki_khoahoc.class));
          }
      });


    }

}