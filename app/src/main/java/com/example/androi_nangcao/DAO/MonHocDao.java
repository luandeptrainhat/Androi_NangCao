package com.example.androi_nangcao.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.androi_nangcao.database.DbHelper;
import com.example.androi_nangcao.model.Monhoc;

import java.util.ArrayList;

public class MonHocDao {
    private DbHelper dbHelper;
    public MonHocDao(Context context){
        dbHelper = new DbHelper(context);
    }
    //lay danh sach mon hoc bao gom cac mon hoc   user da dang ki
    public ArrayList<Monhoc> getDSMonHoc (int id){
        ArrayList<Monhoc> list= new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT mh.code, mh.name, mh.teacher, dk.id FROM MONHOC mh LEFT JOIN DANGKI dk ON mh.code = dk.code AND dk.id = ?", new String[]{String.valueOf(id)});
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                list.add(new Monhoc(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getInt(3)
                ));
            }while (cursor.moveToNext());
        }
        /*
        * SELECT mh.code, mh.name, mh.teacher, dk.id
        * FROM MONHOC mh LEFT JOIN DANGKI dk ON mh.code = dk.code
        * AND dk.id = 1
        * */

        return list;
    }
    //đăng kí khóa học
    public boolean DangKiKhoaHoc(int idNguoiDung, String code){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",idNguoiDung);
        contentValues.put("code",code);
        long check = sqLiteDatabase.insert("DANGKI", null,contentValues);
        if (check==-1){
            return false;
        }return true;
    }
    public boolean  HuyDangKiMonHoc(int idNguoiDung, String code){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        long check = sqLiteDatabase.delete("DANGKI", "id=? AND code =?", new String[]{String.valueOf(idNguoiDung), code});
        if (check==-1){
            return false;
        }return  true;
    }
    public ArrayList<Monhoc> getMyCourse(int idNguoiDung){
        ArrayList<Monhoc> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT mh.code, mh.name, mh.teacher, dk.id  FROM MONHOC mh, DANGKI dk WHERE mh.code = dk.code AND dk.id =?",new String[]{String.valueOf(idNguoiDung)});
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                list.add(new Monhoc(cursor.getString(0),cursor.getString(1), cursor.getString(2), cursor.getInt(3) ));
            }while (cursor.moveToNext());
        }
        return  list;
    }
}
