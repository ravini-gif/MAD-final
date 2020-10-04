package com.example.finalbloodcare;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Add_event extends AppCompatActivity {


    EditText eventname, eventlocation, eventdate, eventtime;
    Button eventadd, eventview;

    @SuppressLint({"wrongContent", "WrongConstant"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        eventname = findViewById(R.id.eventname);
        eventlocation = findViewById(R.id.eventlocation);
        eventdate = findViewById(R.id.eventdate);
        eventtime = findViewById(R.id.eventtime);
        eventadd = findViewById(R.id.eventadd);
        eventview = findViewById(R.id.eventview);

        eventadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(Add_event.this);
                myDB.addHos(eventname.getText().toString().trim(),
                        eventlocation.getText().toString().trim(),
                        Integer.valueOf(eventdate.getText().toString().trim()),
                        Integer.valueOf(eventtime.getText().toString().trim()));
            }
        });

        eventview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity();
            }
        });

    }
    public void openActivity(){
        Intent intent = new Intent(this,read_event_details.class);
        startActivity(intent);
    }

}