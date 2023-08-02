package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Connectivity extends AppCompatActivity {
    ImageButton i1,i2,i3;
    Button b1;
    BluetoothAdapter ba;
    CameraManager cm;
    private static final int REQUEST_ENABLE_BLUETOOTH=4;
//    private boolean bt=false;
    private boolean torch=false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connectivity);
        i1=(ImageButton) findViewById(R.id.imageButton11);
        i2=(ImageButton) findViewById(R.id.imageButton12);
        i3=(ImageButton) findViewById(R.id.imageButton13);
        b1=(Button) findViewById(R.id.button21);
        cm=(CameraManager) getSystemService(CAMERA_SERVICE);
        BluetoothManager bluetoothManager=(BluetoothManager)getSystemService(BLUETOOTH_SERVICE);
        ba=bluetoothManager.getAdapter();
        if(ba==null)
        {
            Toast.makeText(this, "Bluetooth Not Supported", Toast.LENGTH_SHORT).show();
        }
        else
        {
            i1.setOnClickListener(new View.OnClickListener() {

                @SuppressLint("MissingPermission")
                @Override
                public void onClick(View v) {
                    if (!ba.isEnabled()) {
                        Intent i = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                        startActivityForResult(i,REQUEST_ENABLE_BLUETOOTH);

                    }
                }

            });
            i2.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("MissingPermission")
                @Override
                public void onClick(View v) {
                    ba.disable();
                }
            });
        }
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(torch==false)
                {
                    try {
                        String id=cm.getCameraIdList()[0];
                        cm.setTorchMode(id,true);
                        i3.setImageResource(R.drawable.flashoff);
                        torch=true;
                    }
                    catch (CameraAccessException e)
                    {

                    }
                }
                else
                {
                    try {
                        String id=cm.getCameraIdList()[0];
                        cm.setTorchMode(id,false);
                        i3.setImageResource(R.drawable.flashon);
                        torch=false;
                    }
                    catch (CameraAccessException e)
                    {

                    }

                }
            }
        });

    }
}