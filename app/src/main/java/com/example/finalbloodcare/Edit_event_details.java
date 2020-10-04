package com.example.finalbloodcare;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Edit_event_details extends AppCompatActivity {
    EditText edit_event_name, edit_event_location, edit_e_date, edit_e_time;
    Button update_event, delete_event;

    String id, eventname, location, date, time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_event_details);
        edit_event_name = findViewById(R.id.edit_event_name);
        edit_event_location = findViewById(R.id.edit_event_location);
        edit_e_date = findViewById(R.id.edit_e_date);
        edit_e_time = findViewById(R.id.edit_e_time);
        update_event = findViewById(R.id.update_event);
        delete_event = findViewById(R.id.delete_event);

        getAndSetIntentData();
        update_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventDBHelper myDB = new EventDBHelper(Edit_event_details.this);
                eventname = edit_event_name.getText().toString().trim();
                location = edit_event_location.getText().toString().trim();
                date = edit_e_date.getText().toString().trim();
                time =  edit_e_time.getText().toString().trim();
                myDB.updateData(id,eventname,location,date,time);
            }
        });

        delete_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });
    }

    void getAndSetIntentData() {
        if (getIntent().hasExtra("id") && getIntent().hasExtra("name") && getIntent().hasExtra("mail")
                && getIntent().hasExtra("phone")) {
            //getting data from intent
            id = getIntent().getStringExtra("id");
            eventname = getIntent().getStringExtra("eventname");
            location = getIntent().getStringExtra("location");
            date = getIntent().getStringExtra("date");
           time = getIntent().getStringExtra("time");

            //setting intent data
            edit_event_name.setText(eventname);
            edit_event_location.setText(location);
            edit_e_date.setText(date);
            edit_e_time.setText(time);
        } else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + eventname + " ?");
        builder.setMessage("Are you sure you want to delete " + eventname + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(Edit_event_details.this);
                myDB.deleteoneRow(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}