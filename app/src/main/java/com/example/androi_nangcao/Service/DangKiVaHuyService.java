package com.example.androi_nangcao.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.example.androi_nangcao.DAO.MonHocDao;

public class DangKiVaHuyService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle bundle = intent.getExtras();
        String code = bundle.getString("code");
        int idNguoiDung = bundle.getInt("idNguoiDung");
        int type = bundle.getInt("type");

        MonHocDao monHocDao = new MonHocDao(this);
        boolean status = false;

        if (type==1){
            status = monHocDao.DangKiKhoaHoc(idNguoiDung,code);
        }else {
            status = monHocDao.HuyDangKiMonHoc(idNguoiDung,code);
        }
        Intent intentBR = new Intent();
        intentBR.putExtra("status",status);
        intentBR.setAction("DKvH");
        sendBroadcast(intentBR);
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
