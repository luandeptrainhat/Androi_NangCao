package com.example.androi_nangcao.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.example.androi_nangcao.DAO.NguoiDungDao;

public class LoginService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle bundle = intent.getExtras();
        String user = bundle.getString("user");
        String pass = bundle.getString("pass");

        NguoiDungDao nguoiDungDao = new NguoiDungDao(this);
        int idNguoiDung = nguoiDungDao.Login(user, pass);

        // gui qua broadcast
        Intent intentBR = new Intent();
        intentBR.setAction("dangNhap");
        Bundle bundleBR = new Bundle();
        bundleBR.putInt("idNguoiDung", idNguoiDung);
        intentBR.putExtras(bundleBR);
        sendBroadcast(intentBR);


        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }
}
