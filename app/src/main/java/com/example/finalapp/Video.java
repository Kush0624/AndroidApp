package com.example.finalapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class Video extends AppCompatActivity {
    Button b1,b2;
    VideoView v;
    MediaController m;
    Uri u;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        b1=(Button) findViewById(R.id.button18);
        b2=(Button) findViewById(R.id.button19);
        v=(VideoView)findViewById(R.id.videoView);
        m=new MediaController(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(i,100);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Video.this, Fifth.class);
                startActivity(i);
                finish();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100)
        {
            u=data.getData();
            v.setVideoURI(u);
            v.setMediaController(m);
            m.setAnchorView(v);
            v.start();



        }
        else
        {
            Toast.makeText(this, "Your Phone Doesn't Support", Toast.LENGTH_SHORT).show();
        }
    }
}