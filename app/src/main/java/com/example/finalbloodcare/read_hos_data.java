package com.example.finalbloodcare;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class read_hos_data extends AppCompatActivity {

    RecyclerView recyclerView;

    MyDatabaseHelper myDB;
    ArrayList<String> hospital_id, hospital_name, hospital_email, hospital_number;
    HospitalAdapter hospitalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_hos_data);

        recyclerView = findViewById(R.id.recyclerView);

        myDB = new MyDatabaseHelper(read_hos_data.this);
        hospital_id = new ArrayList<>();
        hospital_name = new ArrayList<>();
        hospital_email = new ArrayList<>();
        hospital_number = new ArrayList<>();

        storeDataInArray();

        hospitalAdapter = new HospitalAdapter(read_hos_data.this,this,hospital_id, hospital_name, hospital_email, hospital_number);
        recyclerView.setAdapter(hospitalAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(read_hos_data.this));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    void storeDataInArray() {
        Cursor cursor = myDB.readAllData();

        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                hospital_id.add(cursor.getString(0));
                hospital_name.add(cursor.getString(1));
                hospital_email.add(cursor.getString(2));
                hospital_number.add(cursor.getString(3));
            }
        }
    }
}