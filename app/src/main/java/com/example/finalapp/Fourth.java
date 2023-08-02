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
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hbb20.CountryCodePicker;

public class Fourth extends AppCompatActivity {
    Button b;
    EditText e1,e2,e3,e4;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
  // CountryCodePicker ccp;
   ProgressBar p;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        b=(Button) findViewById(R.id.button6);
        e1=(EditText) findViewById(R.id.editTextText5);
        e2=(EditText) findViewById(R.id.editTextText6);
        e3=(EditText) findViewById(R.id.editTextText7);
        e3.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        e4=(EditText) findViewById(R.id.editTextText8);
        p=(ProgressBar)findViewById(R.id.progressBar2);
        firebaseDatabase=FirebaseDatabase.getInstance();
        firebaseAuth=FirebaseAuth.getInstance();
        //ccp=(CountryCodePicker) findViewById(R.id.ccp1);
        //ccp.registerCarrierNumberEditText(e4);
        p.setVisibility(View.INVISIBLE);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.setVisibility(View.VISIBLE);
                databaseReference = firebaseDatabase.getReference("users");
                String s1= e1.getText().toString();
                String s2= e2.getText().toString();
                String s3= e3.getText().toString();
                String s4=e4.getText().toString();
                if ((s4.length()!=10))
                {
                    Toast.makeText(Fourth.this, "Enter number of 10 digits", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    users users= new users(s1,s2,s3,s4);
                    databaseReference.child(s4).setValue(users);
                    //databaseReference.setValue(users);

                   // Toast.makeText(Fourth.this, "done", Toast.LENGTH_SHORT).show();
                    //p.setVisibility(View.INVISIBLE);
                    firebaseAuth.createUserWithEmailAndPassword(s2,s3).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                //p.setVisibility(View.INVISIBLE);
                                Toast.makeText(Fourth.this, "Sign Up Successfull\nyou can login now", Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(Fourth.this,MainActivity.class);
                                startActivity(i);
                                finish();
                            }
                            else
                            {
                                Toast.makeText(Fourth.this, "Sign Up Unsuccessfull", Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(Fourth.this,MainActivity.class);
                                startActivity(i);
                                finish();
                                //p.setVisibility(View.INVISIBLE);
                            }
                        }
                    });





                }
            }
        });




    }
}