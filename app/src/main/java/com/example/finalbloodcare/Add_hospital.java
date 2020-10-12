package com.example.finalbloodcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Add_hospital extends AppCompatActivity {


    EditText name_input, district_input, number_input;
    Button add, view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hospital);
        name_input = findViewById(R.id.name_input);
        district_input = findViewById(R.id.district_input);
        number_input = findViewById(R.id.phone_input);
        add = findViewById(R.id.add_h_btn);
        view = findViewById(R.id.view_h_btn);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(Add_hospital.this);
                myDB.addHos(name_input.getText().toString().trim(),
                        district_input.getText().toString().trim(),
                        Integer.valueOf(number_input.getText().toString().trim()));
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity();
            }
        });
    }

    public void openActivity() {
        Intent intent = new Intent(this, display_hospitals.class);
        startActivity(intent);
    }
}