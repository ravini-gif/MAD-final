package com.example.finalbloodcare;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Add_h_details extends AppCompatActivity {


    EditText name_input, mail_input, number_input;
    Button btn1, btn2;

    @SuppressLint({"wrongContent", "WrongConstant"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_h_details);
        name_input = findViewById(R.id.name_input);
        mail_input = findViewById(R.id.email_input);
        number_input = findViewById(R.id.phone_input);
        btn1 = findViewById(R.id.addbtn);
        btn2 = findViewById(R.id.viewbtn);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(Add_h_details.this);
                myDB.addHos(name_input.getText().toString().trim(),
                        mail_input.getText().toString().trim(),
                        Integer.valueOf(number_input.getText().toString().trim()), Integer.valueOf(number_input.getText().toString().trim()));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity();
            }
        });

    }
    public void openActivity(){
        Intent intent = new Intent(this,read_hos_data.class);
        startActivity(intent);
    }

}