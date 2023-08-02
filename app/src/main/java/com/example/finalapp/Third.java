package com.example.finalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Third extends AppCompatActivity {
    Button b;
    EditText e;
    ProgressBar p;
    FirebaseAuth firebaseAuth;
    String phone,otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        b=(Button) findViewById(R.id.button5);
        e=(EditText) findViewById(R.id.editTextText4);
        e.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        p=(ProgressBar)findViewById(R.id.progressBar);
        firebaseAuth=FirebaseAuth.getInstance();
        phone=getIntent().getStringExtra("mobile").toString();
        genotp();
        p.setVisibility(View.INVISIBLE);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.setVisibility(View.VISIBLE);
                PhoneAuthCredential credential= PhoneAuthProvider.getCredential(otp,e.getText().toString());
                signinwithcredential(credential);
            }
        });

    }
    private void genotp(){
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone,
                60,
                TimeUnit.SECONDS,
                this,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        super.onCodeSent(s, forceResendingToken);
                        otp=s;
                    }

                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                        signinwithcredential(phoneAuthCredential);

                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {
                        Toast.makeText(Third.this, "OTP mismatched", Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(Third.this, Second.class);
                        startActivity(i);
                        finish();

                    }
                }
        );
    }
    private void signinwithcredential(PhoneAuthCredential phoneAuthCredential)
    {
        firebaseAuth.signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(Third.this, "Verification Complete", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(Third.this, Fifth.class);
                    startActivity(i);
                    finish();


                }
                else
                {
                    Toast.makeText(Third.this, "Firebase Not done", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(Third.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }
}