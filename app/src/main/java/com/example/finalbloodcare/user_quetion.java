package com.example.finalbloodcare;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class user_quetion extends AppCompatActivity {

    Button viewq;
    DatabaseHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_quetion);


        DB = new DatabaseHelper(this);

        viewq = findViewById(R.id.viewq);


        viewq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if (res.getCount() == 0) {
                    Toast.makeText(user_quetion.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Question Number :" + res.getString(0) + "\n");
                    buffer.append("Question :" + res.getString(1) + "\n");
                    buffer.append("Answer :" + res.getString(2) + "\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(user_quetion.this);
                builder.setCancelable(true);

                builder.setTitle("Question Entries");
                builder.setMessage(buffer.toString());
                builder.show();

            }
        });
    }
}