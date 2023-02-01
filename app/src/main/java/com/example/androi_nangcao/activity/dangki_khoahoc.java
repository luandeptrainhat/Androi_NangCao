package com.example.androi_nangcao.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.androi_nangcao.R;
import com.example.androi_nangcao.adapter.DangKiMonHocAdapter;
import com.example.androi_nangcao.modle.khoa_hoc;


import java.util.ArrayList;

public class dangki_khoahoc extends AppCompatActivity {

    private ArrayList<khoa_hoc> list;
    RecyclerView recyclerDangki;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangki_khoahoc);

        recyclerDangki = findViewById(R.id.recycleDangki);

        list = new ArrayList<khoa_hoc>();
        list.add(new khoa_hoc("Lập trình android", R.mipmap.neural));
        list.add(new khoa_hoc("Cơ sở dữ liệu", R.mipmap.register));
        getDS();
    }

    private void getDS() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(dangki_khoahoc.this);
        recyclerDangki.setLayoutManager(linearLayoutManager);
        DangKiMonHocAdapter adapter = new DangKiMonHocAdapter(dangki_khoahoc.this, list);
        recyclerDangki.setAdapter(adapter);
    }
}