package com.example.androi_nangcao.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.androi_nangcao.R;
import com.example.androi_nangcao.Service.DSKhoaHoc_Service;
import com.example.androi_nangcao.adapter.DSKhoaHocAdapter;
import com.example.androi_nangcao.model.Monhoc;


import java.util.ArrayList;

public class DSKhoaHoc extends AppCompatActivity {

    private IntentFilter intentFilter;
    private RecyclerView recyclerDS;
    private int status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.ds_khoa_hoc);
        intentFilter = new IntentFilter();
        intentFilter.addAction("layDSMonHoc");
        intentFilter.addAction("DKvH ");

        Intent intent = getIntent();
        status = intent.getIntExtra("status", -1);
        recyclerDS = findViewById(R.id.recycleDS);
        getDS();

    }

    private void getDS() {
        SharedPreferences sharedPreferences = getSharedPreferences("DATA", MODE_PRIVATE);
        int idNguoiDung = sharedPreferences.getInt("idNguoiDung", -1);
        Intent intent = new Intent(DSKhoaHoc.this, DSKhoaHoc_Service.class);
        intent.putExtra("idNguoiDung", idNguoiDung);
        intent.putExtra("status", status);
        startService(intent);
        
    }

    private void loadData(ArrayList<Monhoc> list) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(DSKhoaHoc.this);
        recyclerDS.setLayoutManager(linearLayoutManager);
        DSKhoaHocAdapter dsKhoaHocAdapter = new DSKhoaHocAdapter(DSKhoaHoc.this, list);
        recyclerDS.setAdapter(dsKhoaHocAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(myBroadcast, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myBroadcast);
    }

    private BroadcastReceiver myBroadcast = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("layDSMonHoc")) {
                Bundle bundle = intent.getExtras();
                ArrayList<Monhoc> list = (ArrayList<Monhoc>) bundle.getSerializable("DSMonHoc");
                loadData(list);
            } else if (intent.getAction().equals("DKvH")) {
                boolean status = intent.getBooleanExtra("status", false);
                if (status) {
                    recyclerDS = findViewById(R.id.recycleDS);
                    getDS();
                    Toast.makeText(context, "thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Không thành công", Toast.LENGTH_SHORT).show();
                }
            }
        }
    };
}