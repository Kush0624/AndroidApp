package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Audioplayer extends AppCompatActivity {
    ImageButton b;
    Button b1;
    MediaPlayer mp;
    private boolean song=false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audioplayer);
        b=(ImageButton) findViewById(R.id.imageButton8);
        b1=(Button)findViewById(R.id.button15);
        mp=MediaPlayer.create(this,R.raw.s);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((song==false))
                {
                    mp.start();
                    b.setImageResource(android.R.drawable.ic_media_pause);
                    song=true;
                }
                else
                {
                    mp.pause();
                    b.setImageResource(android.R.drawable.ic_media_play);
                    song=false;

                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Audioplayer.this, Fifth.class);
                startActivity(i);
                song=false;
                finish();
            }
        });
    }
}