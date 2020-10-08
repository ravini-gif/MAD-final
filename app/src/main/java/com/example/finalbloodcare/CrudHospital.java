package com.example.finalbloodcare;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CrudHospital extends AppCompatActivity {


        EditText hid,email, hname;
        Button addh, viewh, updateh, deleteh;
        database_helper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_hospital);



        email = findViewById(R.id.hname);
            hid = findViewById(R.id.hid);
            hname = findViewById(R.id.hemail);
            addh = findViewById(R.id.addh);
            viewh = findViewById(R.id.viewh);
            updateh = findViewById(R.id.updateh);
            deleteh = findViewById(R.id.deleteh);
            DB = new database_helper(this);

            addh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String qnumTXT = hid.getText().toString();
                    String questionTXT = email.getText().toString();
                    String answerTXT = hname.getText().toString();

                    Boolean checkinsertquestion = DB.insertquestion(qnumTXT,questionTXT, answerTXT);
                    if(checkinsertquestion==true)
                        Toast.makeText(CrudHospital.this,"New Entry Inserted",Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(CrudHospital.this,"New Entry Not Inserted",Toast.LENGTH_SHORT).show();


                }
            });


            updateh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String qnumTXT =hid.getText().toString();
                    String questionTXT = email.getText().toString();
                    String answerTXT = hname.getText().toString();


                    Boolean checkupdatequestion = DB.updatequestion(qnumTXT, questionTXT, answerTXT);
                    if(checkupdatequestion==true)
                        Toast.makeText(CrudHospital.this,"Entry Updated",Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(CrudHospital.this,"New Entry Not Updated",Toast.LENGTH_SHORT).show();


                }
            });


            deleteh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String qnumTXT = hid.getText().toString();

                    Boolean checkdeletequestion = DB.deletequestion(qnumTXT);
                    if(checkdeletequestion==true)
                        Toast.makeText(CrudHospital.this,"Entry Deleted",Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(CrudHospital.this,"New Entry Not Deleted",Toast.LENGTH_SHORT).show();


                }
            });

            viewh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Cursor res = DB.getdata();
                    if(res.getCount()==0) {
                        Toast.makeText(CrudHospital.this,"No Entry Exists",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    StringBuffer buffer = new StringBuffer();
                    while(res.moveToNext()){
                        buffer.append("Hospital id :"+res.getString(0)+"\n");
                        buffer.append("Hospital Name :"+res.getString(1)+"\n");
                        buffer.append("Hospital email :"+res.getString(2)+"\n");
                        buffer.append("");
                   System.out.println("");
                        buffer.append("");
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(CrudHospital.this);
                    builder.setCancelable(true);
                    builder.setTitle("Hospital Details");
                    builder.setMessage(buffer.toString());
                    builder.show();

                }
            });
        }
}