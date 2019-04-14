package com.example.scandinaviangrandmothersapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity
{
    private FirebaseAuth authenticator;

    private EditText emailTxt, passwordTxt;

    private Intent takeMeToSoundboard;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_old);

        DatabaseHandler.initializeDatabase();
        authenticator = FirebaseAuth.getInstance();

        emailTxt = this.findViewById(R.id.emailTxt);
        passwordTxt = this.findViewById(R.id.passwordTxt);

        takeMeToSoundboard = new Intent(this, Soundboard.class);
    }

    public void registerBtnClicked(View v)
    {
        Intent i = new Intent(this, Register.class);

        this.startActivity(i);
    }

    public void loginBtnClicked(View v)
    {
        String emailInput = emailTxt.getText().toString();
        String passwordInput = passwordTxt.getText().toString();

        boolean validInput = true;

        if(emailInput.equals(""))
        {
            validInput = false;
        }

        if(passwordInput.equals(""))
        {
            validInput = false;
        }

        if(validInput)
        {
            authenticator.signInWithEmailAndPassword(emailInput, passwordInput).addOnCompleteListener(new OnCompleteListener<AuthResult>()
            {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task)
                {
                    /*if(task.isSuccessful())
                    {
                        successfulLogin = true;
                    }*/
                }
            });

            authenticator.addAuthStateListener(new FirebaseAuth.AuthStateListener()
            {
                @Override
                public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth)
                {
                    if(firebaseAuth.getCurrentUser() != null && firebaseAuth.getCurrentUser().getEmail().equals(emailTxt.getText().toString()))
                    {
                        MainActivity.super.startActivity(takeMeToSoundboard);
                    }
                }
            });
        }
    }
}
