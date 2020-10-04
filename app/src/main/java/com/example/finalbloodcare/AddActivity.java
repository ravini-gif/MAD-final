package com.example.finalbloodcare;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    EditText title_input,amount_input,bank_input;
    Button addbutton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        title_input = findViewById(R.id.title_input);
        amount_input = findViewById(R.id.amount_input);
        bank_input = findViewById(R.id.bank_input);
        addbutton2 = findViewById(R.id.addbutton2);
        addbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FundDbHelper myDB = new FundDbHelper(AddActivity.this);
                myDB.addFund(title_input.getText().toString().trim(),
                        Float.valueOf(amount_input.getText().toString().trim()),
                        bank_input.getText().toString().trim());
            }

        }  );

    }
}