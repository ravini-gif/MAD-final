package com.example.finalbloodcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuList extends AppCompatActivity {

    private Button reg_donate;
    private Button b_bank;
    private Button view_hos;
    private Button fund;

    private Button faq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);

        reg_donate = (Button) findViewById(R.id.reg_donate);



        reg_donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opendonate();
            }
        });


        b_bank = (Button) findViewById(R.id.b_bank);
        b_bank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBloodDetails();
            }
        });

        view_hos = (Button) findViewById(R.id.view_hos);
        view_hos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAdd_h_details();
            }
        });

        fund = (Button) findViewById(R.id.fund);
        fund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFund();
            }
        });
        faq = (Button) findViewById(R.id.faq);
        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openquestion();
            }
        });


    }

    public void opendonate() {
        Intent intent = new Intent(this, donate.class);
        startActivity(intent);
    }

    /*
        public void open(){
            Intent intent = new Intent(this,register.class);
            startActivity(intent);
        }
    */
    public void openAdd_h_details() {
        Intent intent = new Intent(this, UserHospital.class);
        startActivity(intent);
    }

    public void openFund() {
        Intent intent = new Intent(this, userFund.class);
        startActivity(intent);
    }

    public void openBloodDetails() {
        Intent intent = new Intent(this, User_Bloodbank.class);
        startActivity(intent);
    }

    public void openquestion() {
        Intent intent = new Intent(this, user_quetion.class);
        startActivity(intent);
    }


}