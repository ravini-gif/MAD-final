package com.example.finalbloodcare;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BloodBank extends AppCompatActivity {


    EditText bnum, btype, bamount;
    Button addb, viewb, updateb, deleteb;
    Data_BaseHelperr DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_bank);

        btype = findViewById(R.id.btype);
        bnum = findViewById(R.id.bid);
        bamount = findViewById(R.id.bamount);
        addb = findViewById(R.id.addb);
        viewb = findViewById(R.id.viewb);
        updateb = findViewById(R.id.updateb);
        deleteb = findViewById(R.id.deleteb);
        DB = new Data_BaseHelperr(this);

        addb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String bnumTXT = bnum.getText().toString();
                String btypeTXT = btype.getText().toString();
                String bamountTXT = bamount.getText().toString();

                Boolean checkinsertBloodDetails = DB.insertBloodStock(bnumTXT, btypeTXT, bamountTXT);
                if (checkinsertBloodDetails == true)
                    Toast.makeText(BloodBank.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(BloodBank.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();


            }
        });


        updateb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String bnumTXT = bnum.getText().toString();
                String btypeTXT = btype.getText().toString();
                String bamountTXT = bamount.getText().toString();


                Boolean checkupdatBloodDetails = DB.updateBloodStock(bnumTXT, btypeTXT, bamountTXT);
                if (checkupdatBloodDetails == true)
                    Toast.makeText(BloodBank.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(BloodBank.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();


            }
        });


        deleteb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String qnumTXT = bnum.getText().toString();

                Boolean checkdeletBloodDetails = DB.deleteBloodStock(qnumTXT);
                if (checkdeletBloodDetails == true)
                    Toast.makeText(BloodBank.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(BloodBank.this, "New Entry Not Deleted", Toast.LENGTH_SHORT).show();


            }
        });

        viewb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if (res.getCount() == 0) {
                    Toast.makeText(BloodBank.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("BloodGroup id :" + res.getString(0) + "\n");
                    buffer.append("Blood Group :" + res.getString(1) + "\n");
                    buffer.append("Blood Amount :" + res.getString(2) + "\n");
                    buffer.append("\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(BloodBank.this);
                builder.setCancelable(true);
                builder.setTitle("Blood Stock");
                builder.setMessage(buffer.toString());
                builder.show();

            }
        });
    }
}