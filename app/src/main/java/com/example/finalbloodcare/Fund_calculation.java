package com.example.finalbloodcare;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Fund_calculation extends AppCompatActivity {
    private EditText boc;
    private EditText seylan;
    private EditText nsb;
    private EditText hnb;
    private TextView zero;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boc = findViewById(R.id.boc);
        seylan = findViewById(R.id.seylan);
        nsb = findViewById(R.id.nsb);
        hnb = findViewById(R.id.hnb);
        zero = findViewById(R.id.zero);
        add = findViewById(R.id.add);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (boc.getText().toString().length() ==0) {
                    boc.setText("0");
                }

                if (seylan.getText().toString().length() ==0) {
                    seylan.setText("0");
                }

                if (nsb.getText().toString().length() ==0) {
                    nsb.setText("0");
                }


                if (hnb.getText().toString().length() ==0) {
                    hnb.setText("0");
                }

                int num1 = Integer.parseInt(boc.getText().toString());
                int num2 = Integer.parseInt(seylan.getText().toString());
                int num3 = Integer.parseInt(nsb.getText().toString());
                int num4 = Integer.parseInt(hnb.getText().toString());

                int sum = num1 + num2 + num3 + num4;

                zero.setText(String.valueOf(sum));
            }
        });

    }
}