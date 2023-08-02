package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Vibrate extends AppCompatActivity {
    ImageButton i;
   Vibrator v1;
    Button b;

    @SuppressLint({"MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibrate);
        i=(ImageButton) findViewById(R.id.imageButton10);
        b=(Button) findViewById(R.id.button20);
        v1=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Build.VERSION.SDK_INT>26){
                    v1.vibrate(5000);
                }
                else{
                    v1.vibrate(5000);
                }
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Vibrate.this,Fifth.class);
                startActivity(i);
                finish();
            }
        });


    }
}