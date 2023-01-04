package com.example.androi_nangcao;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public  class myService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("----------------", "onCreate: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("------------------", "onStartCommand: ");
        Bundle bundle = intent.getExtras();
        String data = bundle.getString("data");
        int tuoi = bundle.getInt("tuoi");
        Log.d("------------------", "onStartCommand: "+data + " - "+tuoi);
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        Log.d("-------------", "onDestroy: ");
        super.onDestroy();

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
