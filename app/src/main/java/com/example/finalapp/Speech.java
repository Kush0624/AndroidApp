package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.Locale;

public class Speech extends AppCompatActivity {
    EditText e;
    ImageButton b;
    Button b1;
    TextToSpeech ts;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech);
        e=(EditText) findViewById(R.id.editTextText9);
        b=(ImageButton) findViewById(R.id.imageButton);
        b1=(Button)findViewById(R.id.button8);
        ts=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                ts.setLanguage(Locale.ENGLISH);
                ts.setSpeechRate(0.9f);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=e.getText().toString();
                ts.speak(s,TextToSpeech.QUEUE_FLUSH,null);

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Speech.this, Fifth.class);
                startActivity(i);
                finish();
            }
        });
    }
}