package com.example.androi_nangcao.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.example.androi_nangcao.DAO.MonHocDao;
import com.example.androi_nangcao.model.Monhoc;

import java.util.ArrayList;

public class DSKhoaHoc_Service extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int idNguoiDung = intent.getIntExtra("idNguoiDung",-1);
        MonHocDao monHocDao = new MonHocDao(this);
        ArrayList<Monhoc> list = monHocDao.getDSMonHoc(idNguoiDung);

        Intent intentBR = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("DSMonHoc",list);
        intentBR.putExtras(bundle);
        intentBR.setAction("layDSMonHoc");
        sendBroadcast(intentBR);

        return START_REDELIVER_INTENT;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
