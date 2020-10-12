package com.example.finalbloodcare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class fundDb extends SQLiteOpenHelper {
    public fundDb(Context context) {
        super(context, "Fund.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create table FundDetails(fnum TEXT primary key, bank TEXT, dAmount TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop table if exists FundDetails");
    }

    public Boolean insertFund(String fnum, String bank, String Famount) {

        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("fnum", fnum);
        contentValues.put("bank", bank);
        contentValues.put("dAmount", Famount);
        long result = DB.insert("FundDetails", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }

    public Boolean updateFund(String fnum, String bank, String Famount) {

        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("fnum", fnum);
        contentValues.put("bank", bank);
        contentValues.put("dAmount", Famount);
        Cursor cursor = DB.rawQuery("Select * from FundDetails where fnum = ?", new String[]{fnum});
        if (cursor.getCount() > 0) {

            long result = DB.update("FundDetails", contentValues, "fnum=?", new String[]{fnum});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    public Boolean deleteFund(String fnum) {

        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("Select * from FundDetails where fnum = ?", new String[]{fnum});
        if (cursor.getCount() > 0) {

            long result = DB.delete("FundDetails", "fnum=?", new String[]{fnum});
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

        Cursor cursor = DB.rawQuery("Select * from FundDetails ", null);
        return cursor;

    }


}
