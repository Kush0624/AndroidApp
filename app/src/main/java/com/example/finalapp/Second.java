package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hbb20.CountryCodePicker;

public class Second extends AppCompatActivity {
    Button b;
    EditText e;
    CountryCodePicker ccp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);
        b=(Button) findViewById(R.id.button4);
        e=(EditText) findViewById(R.id.editTextText3);
        ccp=(CountryCodePicker) findViewById(R.id.ccp);
        ccp.registerCarrierNumberEditText(e);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Second.this, Third.class);
                i.putExtra("mobile",ccp.getFullNumberWithPlus().trim());
                startActivity(i);
            }
        });

    }
}