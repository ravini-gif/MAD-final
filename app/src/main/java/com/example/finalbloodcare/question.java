package com.example.finalbloodcare;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLClientInfoException;

public class question extends AppCompatActivity {

    EditText qnum,question, answer;
    Button addq, viewq, updateq, deleteq;
    DatabaseHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        question = findViewById(R.id.question);
        qnum = findViewById(R.id.qnum);
        answer = findViewById(R.id.answer);
        addq = findViewById(R.id.addq);
        viewq = findViewById(R.id.viewq);
        updateq = findViewById(R.id.updateq);
        deleteq = findViewById(R.id.deleteq);
        DB = new DatabaseHelper(this);

        addq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String qnumTXT = qnum.getText().toString();
                String questionTXT = question.getText().toString();
                String answerTXT = answer.getText().toString();

                Boolean checkinsertquestion = DB.insertquestion(qnumTXT,questionTXT, answerTXT);
                if(checkinsertquestion==true)
                    Toast.makeText(question.this,"New Entry Inserted",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(question.this,"New Entry Not Inserted",Toast.LENGTH_SHORT).show();


            }
        });


        updateq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String qnumTXT = qnum.getText().toString();
                String questionTXT = question.getText().toString();
                String answerTXT = answer.getText().toString();


                Boolean checkupdatequestion = DB.updatequestion(qnumTXT, questionTXT, answerTXT);
                if(checkupdatequestion==true)
                    Toast.makeText(question.this,"Entry Updated",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(question.this,"New Entry Not Updated",Toast.LENGTH_SHORT).show();


            }
        });


        deleteq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String qnumTXT = qnum.getText().toString();

                Boolean checkdeletequestion = DB.deletequestion(qnumTXT);
                if(checkdeletequestion==true)
                    Toast.makeText(question.this,"Entry Deleted",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(question.this,"New Entry Not Deleted",Toast.LENGTH_SHORT).show();


            }
        });

        viewq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if(res.getCount()==0) {
                    Toast.makeText(question.this,"No Entry Exists",Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Question Number :"+res.getString(0)+"\n");
                    buffer.append("Question :"+res.getString(1)+"\n");
                    buffer.append("Answer :"+res.getString(2)+"\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(question.this);
                builder.setCancelable(true);
                builder.setTitle("Question Entries");
                builder.setMessage(buffer.toString());
                builder.show();

            }
        });
    }
}
