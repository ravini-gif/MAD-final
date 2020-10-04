package com.example.finalbloodcare;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class donate extends AppCompatActivity {

        EditText dusername, age, bloodgroup, contactno;
        Button regdonate, viewdonate, update, delete;
        SQLiteHelper DB;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_donate);

            dusername = findViewById(R.id.dusername);
            age = findViewById(R.id.age);
            bloodgroup = findViewById(R.id.bloodgroup);
            contactno = findViewById(R.id.contactno);
            regdonate = findViewById(R.id.regdonate);
            viewdonate = findViewById(R.id.viewdonate);
            update = findViewById(R.id.update);
            delete = findViewById(R.id.delete);
            DB = new SQLiteHelper(this);

            regdonate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String nameTXT = dusername.getText().toString();
                    String bloodgroupTXT = bloodgroup.getText().toString();
                    String ageINT = age.getText().toString();
                    String contactnoINT = contactno.getText().toString();

                    Boolean checkinsertdata = DB.insertuserdata(nameTXT, bloodgroupTXT, ageINT, contactnoINT);
                    if (checkinsertdata == true)
                        Toast.makeText(donate.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(donate.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();


                }
            });


            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String nameTXT = dusername.getText().toString();
                    String bloodgroupTXT = bloodgroup.getText().toString();
                    String ageINT = age.getText().toString();
                    String contactnoINT = contactno.getText().toString();

                    Boolean checkupdatedata = DB.updateuserdata(nameTXT, bloodgroupTXT, ageINT, contactnoINT);
                    if (checkupdatedata == true)
                        Toast.makeText(donate.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(donate.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();


                }
            });


            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String nameTXT = dusername.getText().toString();

                    Boolean checkdeletedata = DB.deletedata(nameTXT);
                    if (checkdeletedata == true)
                        Toast.makeText(donate.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(donate.this, "New Entry Not Deleted", Toast.LENGTH_SHORT).show();


                }
            });

            viewdonate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Cursor res = DB.getdata();
                    if (res.getCount() == 0) {
                        Toast.makeText(donate.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    StringBuffer buffer = new StringBuffer();
                    while (res.moveToNext()) {
                        buffer.append("Name :" + res.getString(0) + "\n");
                        buffer.append("Blood Group :" + res.getString(1) + "\n");
                        buffer.append("Age :" + res.getString(2) + "\n");
                        buffer.append("Contact No :" + res.getString(3) + "\n\n");
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(donate.this);
                    builder.setCancelable(true);
                    builder.setTitle("User Entries");
                    builder.setMessage(buffer.toString());
                    builder.show();

                }
            });
        }
    }


