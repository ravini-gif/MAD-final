package com.example.finalbloodcare;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.View.*;

public class register extends AppCompatActivity {

    EditText username, email, password, repassword;
    Button submit, submit2;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = (EditText) findViewById(R.id.userName);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        submit =(Button) findViewById(R.id.submit);
        submit2 =(Button) findViewById(R.id.submit2);
        DB = new DBHelper(this);

        submit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String emle = email.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();


                if(user.equals("") || emle.equals("") || pass.equals("") || repass.equals(""))
                    Toast.makeText(register.this, "Please enter all the fields." ,Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user, pass);
                            if(insert==true){
                                Toast.makeText(register.this,"Register Successfully!" ,Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MenuList.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(register.this, "Registration Failed !" ,Toast.LENGTH_SHORT).show();

                            }
                        }
                        else{
                            Toast.makeText(register.this, " User already exists! Please Sign In" ,Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(register.this, "Password not matching !" ,Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        submit2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

