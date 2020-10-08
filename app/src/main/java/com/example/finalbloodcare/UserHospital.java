package com.example.finalbloodcare;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserHospital extends AppCompatActivity {
    Button viewh;
    database_helper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_hospital);


        DB = new database_helper(this);

        viewh = findViewById(R.id.viewh);


        viewh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if (res.getCount() == 0) {
                    Toast.makeText(UserHospital.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Question Number :" + res.getString(0) + "\n");
                    buffer.append("Question :" + res.getString(1) + "\n");
                    buffer.append("Answer :" + res.getString(2) + "\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(UserHospital.this);
                builder.setCancelable(true);
                builder.setTitle("Question Entries");
                builder.setMessage(buffer.toString());
                builder.show();

            }
        });
    }
}