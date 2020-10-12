package com.example.finalbloodcare;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Edit_hospital extends AppCompatActivity {


    EditText name_update, district_update, number_update;
    Button btn1, delete_btn;

    String id, name, district, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_hospital);

        name_update = findViewById(R.id.name_input2);
        district_update = findViewById(R.id.district_input2);
        number_update = findViewById(R.id.phone_input2);
        btn1 = findViewById(R.id.updatebtn);

        delete_btn = findViewById(R.id.deletebtn);

        getAndSetIntentData();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(Edit_hospital.this);
                name = name_update.getText().toString().trim();
                district = district_update.getText().toString().trim();
                phone = number_update.getText().toString().trim();
                myDB.updateData(id, name, district, phone);
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
        if (getIntent().hasExtra("id") && getIntent().hasExtra("name") && getIntent().hasExtra("district")
                && getIntent().hasExtra("phone")) {
            //getting data from intent
            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");
            district = getIntent().getStringExtra("district");
            phone = getIntent().getStringExtra("phone");

            //setting intent data
            name_update.setText(name);
            district_update.setText(district);
            number_update.setText(phone);
        } else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + name + " ?");
        builder.setMessage("Are you sure you want to delete " + name + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(Edit_hospital.this);
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