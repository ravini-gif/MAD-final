package com.example.finalbloodcare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Data_BaseHelperr extends SQLiteOpenHelper {

    public Data_BaseHelperr(Context context) {
        super(context, "Bloodbank.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create table BloodDetails(bid TEXT primary key, Btype TEXT, Bamount TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop table if exists BloodDetails");
    }

    public Boolean insertBloodStock(String bnum, String btype, String bamount) {

        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("bid ", bnum);
        contentValues.put(" Btype ", btype);
        contentValues.put("Bamount",bamount);
        long result = DB.insert("BloodDetails", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }

    public Boolean updateBloodStock(String bnum, String btype, String bamount) {

        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("bid ", bnum);
        contentValues.put(" Btype ", btype);
        contentValues.put("Bamount",bamount);
        Cursor cursor = DB.rawQuery("Select * from BloodDetails where bid = ?", new String[]{bnum});
        if (cursor.getCount() > 0) {

            long result = DB.update("BloodDetails", contentValues, "bid=?", new String[]{bnum});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    public Boolean deleteBloodStock(String bnum) {

        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("Select * from BloodDetails where bid = ?", new String[]{bnum});
        if (cursor.getCount() > 0) {

            long result = DB.delete("BloodDetails", "bid=?",new String[]{bnum});
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

        Cursor cursor = DB.rawQuery("Select * from BloodDetails ", null);
        return cursor;

    }

}
