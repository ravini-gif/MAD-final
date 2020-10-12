package com.example.finalbloodcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class admin_menu extends AppCompatActivity {

    Button m_hos, m_fund, manage_faq, m_bgroup, fund_calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);


        m_hos = findViewById(R.id.manage_hos);
        m_fund = findViewById(R.id.manage_fund);
        fund_calculate = findViewById(R.id.manage_fund_cal);
        manage_faq = findViewById(R.id.manage_faq);
        m_bgroup = findViewById(R.id.manage_bGroup);

        m_hos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity();
            }
        });
        m_fund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });

        fund_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity6();
            }
        });
        manage_faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity4();
            }
        });
        m_bgroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity5();
            }
        });
    }

    public void openActivity() {
        Intent intent = new Intent(admin_menu.this, Add_hospital.class);
        startActivity(intent);
    }

    public void openActivity2() {
        Intent intent = new Intent(admin_menu.this, Fund.class);
        startActivity(intent);
    }


    public void openActivity4() {
        Intent intent = new Intent(admin_menu.this, question.class);
        startActivity(intent);
    }

    public void openActivity5() {
        Intent intent = new Intent(admin_menu.this, BloodBank.class);
        startActivity(intent);
    }

    public void openActivity6() {
        Intent intent = new Intent(admin_menu.this, FundCalculator.class);
        startActivity(intent);
    }
}