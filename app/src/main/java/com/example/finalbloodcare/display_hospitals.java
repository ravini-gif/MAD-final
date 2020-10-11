package com.example.finalbloodcare;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class display_hospitals extends AppCompatActivity {


        RecyclerView recyclerView;

        MyDatabaseHelper myDB;
        ArrayList<String> hospital_id, hospital_name, hospital_district, hospital_number;
        HospitalAdapter hospitalAdapter;

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_display_hospitals);


            recyclerView = findViewById(R.id.recyclerView);

            myDB = new MyDatabaseHelper(display_hospitals.this);
            hospital_id = new ArrayList<>();
            hospital_name = new ArrayList<>();
            hospital_district = new ArrayList<>();
            hospital_number = new ArrayList<>();

            storeDataInArray();

            hospitalAdapter = new HospitalAdapter(display_hospitals.this, this, hospital_id, hospital_name, hospital_district, hospital_number);
            recyclerView.setAdapter(hospitalAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(display_hospitals.this));

        }

        @Override
        protected void onActivityResult ( int requestCode, int resultCode, @Nullable Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == 1) {
                recreate();
            }
        }

        void storeDataInArray () {
            Cursor cursor = myDB.readAllData();

            if (cursor.getCount() == 0) {
                Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
            } else {
                while (cursor.moveToNext()) {
                    hospital_id.add(cursor.getString(0));
                    hospital_name.add(cursor.getString(1));
                    hospital_district.add(cursor.getString(2));
                    hospital_number.add(cursor.getString(3));
                }
            }
        }
    }
