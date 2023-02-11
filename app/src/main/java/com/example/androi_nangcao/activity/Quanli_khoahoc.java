package com.example.androi_nangcao.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.androi_nangcao.R;

public class Quanli_khoahoc extends AppCompatActivity {
    LinearLayout dskhoahoc, khoahoccuatoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanli_khoahoc);

        dskhoahoc= findViewById(R.id.dangki);
        khoahoccuatoi= findViewById(R.id.dadangki);

        dskhoahoc.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
             Intent intent = new Intent(Quanli_khoahoc.this,DSKhoaHoc.class);
             intent.putExtra("status",1);
             //laays tất cả khóa học
              startActivity(intent);
          }
      });
        khoahoccuatoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Quanli_khoahoc.this,DSKhoaHoc.class);
                intent.putExtra("status",0);
                //laays  khóa học của tôi
                startActivity(intent);
            }
        });

    }

}