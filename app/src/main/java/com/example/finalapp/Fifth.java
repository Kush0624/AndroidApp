package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Fifth extends AppCompatActivity {
    Button b;
    TextView t;
    ImageButton i1,i2,i3,i4,i5,i6,i7;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        b=(Button) findViewById(R.id.button7);
        t=(TextView) findViewById(R.id.textView7);
        i1=(ImageButton)findViewById(R.id.imageButton2);
        i2=(ImageButton)findViewById(R.id.imageButton3);
        i3=(ImageButton)findViewById(R.id.imageButton4);
        i4=(ImageButton)findViewById(R.id.imageButton5);
        i5=(ImageButton)findViewById(R.id.imageButton6);
        i6=(ImageButton)findViewById(R.id.imageButton7);
        i7=(ImageButton)findViewById(R.id.imageButton9);
        firebaseAuth=FirebaseAuth.getInstance();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                Toast.makeText(Fifth.this, "Log Out", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(Fifth.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Fifth.this,Speech.class);
                startActivity(i);
                finish();
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Fifth.this, Calculator.class);
                startActivity(i);
                finish();
            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Fifth.this, Audioplayer.class);
                startActivity(i);
                finish();
            }
        });
        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Fifth.this, Camera.class);
                startActivity(i);
                finish();
            }
        });
        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Fifth.this, Video.class);
                startActivity(i);
                finish();
            }
        });
        i7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Fifth.this, Vibrate.class);
                startActivity(i);
                finish();
            }
        });
        i6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Fifth.this, Connectivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}