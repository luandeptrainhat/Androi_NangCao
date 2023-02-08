package com.example.androi_nangcao.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.androi_nangcao.R;
import com.example.androi_nangcao.Service.LoginService;


public class login extends AppCompatActivity {
private IntentFilter intentFilter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText edtuser = findViewById(R.id.username);
        EditText edtpass = findViewById(R.id.password);
        Button btnLogin = findViewById(R.id.btnLogin);

        //khai bao internfilter
        intentFilter = new IntentFilter();
        intentFilter.addAction("dangNhap");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=edtuser.getText().toString();
                String pass=edtpass.getText().toString();

                Intent intent = new Intent(login.this, LoginService.class);
                Bundle bundle = new Bundle();

                bundle.putString("user", user);
                bundle.putString("pass", pass);
                intent.putExtras(bundle);
                startService(intent);
            }
        });
    }

    @Override
    protected void onStart() {

        super.onStart();
        registerReceiver(myBroadcast, intentFilter );
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myBroadcast);
    }

    public BroadcastReceiver myBroadcast = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //check action de thuc hien chuc nang
            if (intent.getAction().equals("dangNhap")){
                Bundle bundle = intent.getExtras();
                int idNguoiDung = bundle.getInt("idNguoiDung");
                Toast.makeText(context, ""+idNguoiDung, Toast.LENGTH_SHORT).show();
                SharedPreferences sharedPreferences = getSharedPreferences("DATA",MODE_PRIVATE);
                SharedPreferences.Editor editor =sharedPreferences.edit();
                editor.putInt("idNguoiDung",idNguoiDung);
                editor.apply();
                startActivity(new Intent(login.this,Home.class));
            }
        }
    };

}