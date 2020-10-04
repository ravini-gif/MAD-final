package com.example.finalbloodcare;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, "Questiondata.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create table Questiondetails(qnum TEXT primary key, question TEXT, answer TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop table if exists Questiondetails");
    }

    public Boolean insertquestion(String qnum, String question, String answer) {

        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("qnum", qnum);
        contentValues.put("question", question);
        contentValues.put("answer", answer);
        long result = DB.insert("Questiondetails", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }

    public Boolean updatequestion(String qnum, String question, String answer) {

        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("qnum", qnum);
        contentValues.put("question", question);
        contentValues.put("answer", answer);
        Cursor cursor = DB.rawQuery("Select * from Questiondetails where qnum = ?", new String[]{qnum});
        if (cursor.getCount() > 0) {

            long result = DB.update("Questiondetails", contentValues, "qnum=?", new String[]{qnum});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    public Boolean deletequestion(String qnum) {

        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("Select * from Questiondetails where qnum = ?", new String[]{qnum});
        if (cursor.getCount() > 0) {

            long result = DB.delete("Questiondetails", "qnum=?",new String[]{qnum});
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

        Cursor cursor = DB.rawQuery("Select * from Questiondetails ", null);
        return cursor;

    }


}
