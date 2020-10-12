package com.example.finalbloodcare;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Fund extends AppCompatActivity {
    /*Button button, btncal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fund);

        button = (Button) findViewById(R.id.button);
        btncal = (Button) findViewById(R.id.btncal);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity();
            }
        });

        btncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });

    }
    public void openActivity(){
        Intent intent = new Intent(Fund.this,AddActivity.class);
        startActivity(intent);
    }

    public void openActivity2(){
        Intent intent = new Intent(Fund.this,Fund_calculation.class);
        startActivity(intent);
    }*/


    EditText fnum, bank, amount;
    Button addf, viewf, updatef, deletef;
    fundDb DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fund);

        bank = findViewById(R.id.bank);
        fnum = findViewById(R.id.fnum);
        amount = findViewById(R.id.amount);
        addf = findViewById(R.id.addf);
        viewf = findViewById(R.id.viewf);
        updatef = findViewById(R.id.updatef);
        deletef = findViewById(R.id.deletef);
        DB = new fundDb(this);

        addf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String qnumTXT = fnum.getText().toString();
                String questionTXT = bank.getText().toString();
                String answerTXT = amount.getText().toString();

                Boolean checkinsertfund = DB.insertFund(qnumTXT, questionTXT, answerTXT);
                if (checkinsertfund == true)
                    Toast.makeText(Fund.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Fund.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();


            }
        });


        updatef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String qnumTXT = fnum.getText().toString();
                String questionTXT = bank.getText().toString();
                String answerTXT = amount.getText().toString();


                Boolean checkupdatefund = DB.updateFund(qnumTXT, questionTXT, answerTXT);
                if (checkupdatefund == true)
                    Toast.makeText(Fund.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Fund.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();


            }
        });


        deletef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fnumTXT = fnum.getText().toString();

                Boolean checkdeletefund = DB.deleteFund(fnumTXT);
                if (checkdeletefund == true)
                    Toast.makeText(Fund.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Fund.this, "New Entry Not Deleted", Toast.LENGTH_SHORT).show();


            }
        });

        viewf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if (res.getCount() == 0) {
                    Toast.makeText(Fund.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Fund Number :" + res.getString(0) + "\n");
                    buffer.append("Bank Name :" + res.getString(1) + "\n");
                    buffer.append("Amount :" + res.getString(2) + "\n");
                    buffer.append("\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(Fund.this);
                builder.setCancelable(true);
                builder.setTitle("Fund Entries");
                builder.setMessage(buffer.toString());
                builder.show();

            }
        });
    }

}

