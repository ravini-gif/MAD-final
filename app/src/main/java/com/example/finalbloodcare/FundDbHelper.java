package com.example.finalbloodcare;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class FundDbHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "fund.db";
    private static final String DATABASE_VERSION = "1";
    private static final String TABLE_NAME = "bc_fund";
    private static final String COLOMN_ID = "id";
    private static final String COLOMN_TITLE = "Name";
    private static final String COLOMN_AMOUNT = "Deposited Amount";
    private static final String COLOMN_BANK = "Bank";

    public FundDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, Integer.parseInt(DATABASE_VERSION));
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = " CREATE TABLE " + " TABLE_NAME " +
                " ( " + " COLOMN_ID " + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                " COLOMN_TITLE " + " TEXT, " +
                " COLOMN_AMOUNT " + " FLOAT, " +
                " COLOMN_BANK " + " TEXT ); ";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    void addFund(String title, float amount, String bank) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLOMN_TITLE, title);
        cv.put(COLOMN_AMOUNT, amount);
        cv.put(COLOMN_BANK, bank);
        long result = db.insert(TABLE_NAME, null, cv);

        if (result == -1) {
            Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show();
            Toast.makeText(context, "Added successfully", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(context, "Added successfully", Toast.LENGTH_SHORT).show();
        }

    }


}
