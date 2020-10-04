package com.example.finalbloodcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class admin_menu extends AppCompatActivity {

    Button m_hos,m_fund,m_event, manage_faq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);

        m_hos = findViewById(R.id.manage_hos);
        m_fund = findViewById(R.id.manage_fund);
        m_event=findViewById(R.id.event);
        manage_faq = findViewById(R.id.manage_faq);

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
        m_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity3();
            }
        });

        manage_faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity4();
            }
        });
    }

    public void openActivity(){
        Intent intent=new Intent(admin_menu.this,Add_h_details.class);
        startActivity(intent);
    }

    public void openActivity2(){
        Intent intent=new Intent(admin_menu.this,Fund.class);
        startActivity(intent);
    }
    public void openActivity3(){
        Intent intent=new Intent(admin_menu.this,Add_event.class);
        startActivity(intent);
    }

    public void openActivity4(){
        Intent intent=new Intent(admin_menu.this,question.class);
        startActivity(intent);
    }
}