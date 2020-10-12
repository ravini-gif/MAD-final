package com.example.finalbloodcare;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class userFund extends AppCompatActivity {


    Button viewf, viewb;
    fundDb DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_fund);

        DB = new fundDb(this);
        viewb = findViewById(R.id.viewbank);

        viewb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBank();
            }
        });

        viewf = findViewById(R.id.viewf);


        viewf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if (res.getCount() == 0) {
                    Toast.makeText(userFund.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Fund Number :" + res.getString(0) + "\n");
                    buffer.append("Bank Name :" + res.getString(1) + "\n");
                    buffer.append("Amount :" + res.getString(2) + "\n");
                    buffer.append("\n");

                }

                AlertDialog.Builder builder = new AlertDialog.Builder(userFund.this);
                builder.setCancelable(true);
                builder.setTitle("Fund Details");
                builder.setMessage(buffer.toString());
                builder.show();

            }
        });
    }

    public void openBank() {
        Intent intent = new Intent(this, Account_details.class);
        startActivity(intent);
    }
}