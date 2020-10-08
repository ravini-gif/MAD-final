package com.example.finalbloodcare;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class database_helper extends SQLiteOpenHelper {

    public database_helper(Context context) {
        super(context, "HospitalsDetails.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create table HDetails(hid TEXT primary key, hName TEXT, email TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop table if exists HDetails");
    }

    public Boolean insertHospital(String hid, String hname, String email) {

        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hid", hid);
        contentValues.put("hName ", hname);
        contentValues.put(" email ", email);
        long result = DB.insert(" HDetails", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }

    public Boolean updateHospital(String hid, String hname, String email) {

        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hid", hid);
        contentValues.put("hName ", hname);
        contentValues.put(" email ", email);
        Cursor cursor = DB.rawQuery("Select * from HDetails where hid = ?", new String[]{ hid});
        if (cursor.getCount() > 0) {

            long result = DB.update("HDetails", contentValues, "hid=?", new String[]{ hid});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    public Boolean deleteHospital(String hid) {

        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("Select * from HDetails where hid= ?", new String[]{hid});
        if (cursor.getCount() > 0) {

            long result = DB.delete("HDetails", "hid=?",new String[]{hid});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    public Cursor getdata() {

        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("Select * from HDetails ", null);
        return cursor;

    }


}
