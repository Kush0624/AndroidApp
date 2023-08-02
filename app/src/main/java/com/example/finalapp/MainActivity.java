package com.example.finalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3;
    EditText e1,e2;
    FirebaseAuth firebaseAuth;






    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.button);
        b2=(Button) findViewById(R.id.button2);
        b3=(Button) findViewById(R.id.button3);
        e1=(EditText) findViewById(R.id.editTextText);
        e2=(EditText) findViewById(R.id.editTextText2);
        e2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        firebaseAuth=FirebaseAuth.getInstance();







        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this, Fourth.class);
                startActivity(i);
                finish();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this, Second.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                if (s1.isEmpty()) {
                    e1.setError("Fill up details first");
                    return;
                } else {
                    if (s2.isEmpty()) {
                        e2.setError("Enter Password");
                        return;
                    } else {
                        //p.setVisibility(View.VISIBLE);
                        firebaseAuth.signInWithEmailAndPassword(s1, s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                    //p.setVisibility(View.INVISIBLE);
                                    Intent i = new Intent(MainActivity.this, Fifth.class);
                                    startActivity(i);
                                    finish();

                                } else {
                                    Toast.makeText(MainActivity.this, "Username or password Incorrect", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }
            }
        });


    }


}