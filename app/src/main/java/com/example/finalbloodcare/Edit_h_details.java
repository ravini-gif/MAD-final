package com.example.finalbloodcare;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Edit_h_details extends AppCompatActivity {

    EditText name_update, mail_update, number_update;
    Button btn1,delete_btn;

    String id, name, mail, phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_h_details);
        name_update = findViewById(R.id.name_input2);
        mail_update = findViewById(R.id.email_input2);
        number_update = findViewById(R.id.phone_input2);
        btn1 = findViewById(R.id.updatebtn);

        delete_btn = findViewById(R.id.deletebtn);

        getAndSetIntentData();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(Edit_h_details.this);
                name = name_update.getText().toString().trim();
                mail = mail_update.getText().toString().trim();
                phone = number_update.getText().toString().trim();
                myDB.updateData(id,name,mail,phone);
            }
        });

        delete_btn.setOnClickListener(new View.OnClickListener() {
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
            name = getIntent().getStringExtra("name");
            mail = getIntent().getStringExtra("mail");
            phone = getIntent().getStringExtra("phone");

            //setting intent data
            name_update.setText(name);
            mail_update.setText(mail);
            number_update.setText(phone);
        } else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + name + " ?");
        builder.setMessage("Are you sure you want to delete " + name + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(Edit_h_details.this);
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