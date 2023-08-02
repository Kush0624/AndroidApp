package com.example.finalapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Camera extends AppCompatActivity {
    ImageView iv;
    Button b1,b2;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        b1=(Button) findViewById(R.id.button16);
        b2=(Button) findViewById(R.id.button17);
        iv=(ImageView) findViewById(R.id.imageView);
       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
               startActivityForResult(i,100);
           }
       });
       b2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i=new Intent(Camera.this, Fifth.class);
               startActivity(i);
               finish();
           }
       });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode==100))
        {
            Bitmap bm=(Bitmap) data.getExtras().get("data");
            iv.setImageBitmap(bm);
        }
        else
        {
            Toast.makeText(this, "Your Phone Doesn't Support", Toast.LENGTH_SHORT).show();
        }
    }
}