package com.example.finalbloodcare;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class User_Bloodbank extends AppCompatActivity {

    Button viewb;
    Data_BaseHelperr DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__bloodbank);

        DB = new Data_BaseHelperr(this);

        viewb = findViewById(R.id.viewb);


        viewb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if (res.getCount() == 0) {
                    Toast.makeText(User_Bloodbank.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("BloodGroup id :" + res.getString(0) + "\n");
                    buffer.append("Blood Group :" + res.getString(1) + "\n");
                    buffer.append("Blood Amount :" + res.getString(2) + "\n");
                    buffer.append("\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(User_Bloodbank.this);
                builder.setCancelable(true);

                builder.setTitle("Blood Stock Details");
                builder.setMessage(buffer.toString());
                builder.show();

            }
        });
    }
}