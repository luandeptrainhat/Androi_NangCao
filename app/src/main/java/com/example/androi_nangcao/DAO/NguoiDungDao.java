package com.example.androi_nangcao.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.androi_nangcao.database.DbHelper;

public class NguoiDungDao {
    private DbHelper dbHelper;
    public NguoiDungDao(Context context){
        dbHelper = new DbHelper(context);
    }
    public int  Login(String user, String pass){
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM NGUOIDUNG WHERE username = ? AND password=?",new String[]{user, pass});
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            return  cursor.getInt(0);
        }
        return -1;
    }

}
