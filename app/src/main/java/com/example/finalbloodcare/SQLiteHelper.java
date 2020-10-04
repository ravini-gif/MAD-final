package com.example.finalbloodcare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


    public class SQLiteHelper extends SQLiteOpenHelper {

        public SQLiteHelper(Context context) {
            super(context, "Userdata.db", null, 1);
        }


        @Override
        public void onCreate(SQLiteDatabase DB) {
            DB.execSQL("create table Userdetails(name TEXT primary key, bloodgroup TEXT, age INT, contactno INT )");

        }

        @Override
        public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
            DB.execSQL("drop table if exists Userdetails");
        }

        public Boolean insertuserdata(String name, String bloodgroup, String age, String contactno) {

            SQLiteDatabase DB = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", name);
            contentValues.put("bloodgroup", bloodgroup);
            contentValues.put("age", age);
            contentValues.put("contactno", contactno);
            long result = DB.insert("Userdetails", null, contentValues);
            if (result == -1) {
                return false;
            } else {
                return true;
            }

        }

        public Boolean updateuserdata(String name, String bloodgroup, String age, String contactno) {

            SQLiteDatabase DB = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("bloodgroup", bloodgroup);
            contentValues.put("age", age);
            contentValues.put("contactno", contactno);
            Cursor cursor = DB.rawQuery("Select * from Userdetails where name = ?", new String[]{name});
            if (cursor.getCount() > 0) {

                long result = DB.update("Userdetails", contentValues, "name=?", new String[]{name});
                if (result == -1) {
                    return false;
                } else {
                    return true;
                }
            } else {
                return false;
            }

        }

        public Boolean deletedata(String name) {

            SQLiteDatabase DB = this.getWritableDatabase();

            Cursor cursor = DB.rawQuery("Select * from Userdetails where name = ?", new String[]{name});
            if (cursor.getCount() > 0) {

                long result = DB.delete("Userdetails", "name=?",new String[]{name});
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

            Cursor cursor = DB.rawQuery("Select * from Userdetails ", null);
            return cursor;

        }




    }
