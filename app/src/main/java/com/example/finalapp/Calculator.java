package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2,b3,b4,b5,b6;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        e1=(EditText) findViewById(R.id.editTextText10);
        e2=(EditText) findViewById(R.id.editTextText11);
        b1=(Button) findViewById(R.id.button9);
        b2=(Button) findViewById(R.id.button10);
        b3=(Button) findViewById(R.id.button11);
        b4=(Button) findViewById(R.id.button12);
        b5=(Button) findViewById(R.id.button13);
        b6=(Button) findViewById(R.id.button14);
        tv=(TextView) findViewById(R.id.textView18);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=e1.getText().toString();
                String s1=e2.getText().toString();


               if ((s1.isEmpty()|| s.isEmpty()))
               {
                   Toast.makeText(Calculator.this, "Enter number to compute", Toast.LENGTH_SHORT).show();
               }
               else
               {
                   Integer i1=Integer.parseInt(s);
                   Integer i2=Integer.parseInt(s1);
                   Integer i3=i1+i2;
                   String s2=Integer.toString(i3);
                   tv.setText(s2);
               }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            String s=e1.getText().toString();
            String s1=e2.getText().toString();

            @Override
            public void onClick(View v) {
                if ((s1.isEmpty()|| s.isEmpty()))
                {
                    Toast.makeText(Calculator.this, "Enter number to compute", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Integer i1=Integer.parseInt(s);
                    Integer i2=Integer.parseInt(s1);
                    Integer i3=i1-i2;
                    String s2=Integer.toString(i3);
                    tv.setText(s2);
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            String s=e1.getText().toString();
            String s1=e2.getText().toString();

            @Override
            public void onClick(View v) {
                String s=e1.getText().toString();
                String s1=e2.getText().toString();
                if ((s1.isEmpty()|| s.isEmpty()))
                {
                    Toast.makeText(Calculator.this, "Enter number to compute", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Integer i1=Integer.parseInt(s);
                    Integer i2=Integer.parseInt(s1);
                    Integer i3=i1*i2;
                    String s2=Integer.toString(i3);
                    tv.setText(s2);
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            String s=e1.getText().toString();
            String s1=e2.getText().toString();

            @Override
            public void onClick(View v) {
                if ((s1.isEmpty()|| s.isEmpty()))
                {
                    Toast.makeText(Calculator.this, "Enter number to compute", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Integer i1=Integer.parseInt(s);
                    Integer i2=Integer.parseInt(s1);
                    Integer i3=i1/i2;
                    String s2=Integer.toString(i3);
                    tv.setText(s2);
                }
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Integer i3=i1+i2;
//                String s2=Integer.toString(i3);
                e1.setText("");
                e2.setText("");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Calculator.this, Fifth.class);
                startActivity(i);
                finish();
            }
        });

    }
}