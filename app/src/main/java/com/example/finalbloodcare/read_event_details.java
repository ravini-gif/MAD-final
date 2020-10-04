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

public class read_event_details extends AppCompatActivity {


    RecyclerView recyclerView;

    EventDBHelper myDB;
    ArrayList<String> event_id, event_name, location, date,time;
    EventAdapter eventAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_event_details);

        recyclerView = findViewById(R.id.recyclerView2);

        myDB = new EventDBHelper(read_event_details.this);
        event_id = new ArrayList<>();
        event_name = new ArrayList<>();
        location= new ArrayList<>();
        date = new ArrayList<>();
        time = new ArrayList<>();

        storeDataInArray();

        eventAdapter = new EventAdapter(read_event_details.this,this,event_id, event_name, location, date,time);
        recyclerView.setAdapter(eventAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(read_event_details.this));

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
                event_id.add(cursor.getString(0));
                event_name.add(cursor.getString(1));
                location.add(cursor.getString(2));
                date.add(cursor.getString(3));
                time.add(cursor.getString(3));
            }
        }
    }
}