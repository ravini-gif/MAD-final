package com.example.finalbloodcare;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Fund extends AppCompatActivity {
    Button button, btncal;


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
    }

}

