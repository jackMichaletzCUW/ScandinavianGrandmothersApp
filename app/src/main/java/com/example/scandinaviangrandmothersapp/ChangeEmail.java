package com.example.scandinaviangrandmothersapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class ChangeEmail extends AppCompatActivity
{
    private EditText emailTxt;
    private FirebaseAuth authenticator;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_email);

        emailTxt = this.findViewById(R.id.emailTxt);

        authenticator = FirebaseAuth.getInstance();
    }

    public void changeBtnPressed(View v)
    {
        String UID = authenticator.getUid();

        String emailInput = emailTxt.getText().toString();

        DatabaseHandler.changeData(UID, "email", emailInput);

        authenticator.getCurrentUser().updateEmail(emailInput);

        this.startActivity(new Intent(this, Soundboard.class));
    }
}
