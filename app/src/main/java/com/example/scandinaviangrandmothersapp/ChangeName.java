package com.example.scandinaviangrandmothersapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class ChangeName extends AppCompatActivity
{
    private EditText firstNameTxt, lastNameTxt;
    private FirebaseAuth authenticator;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_name);

        firstNameTxt = this.findViewById(R.id.firstNameTxt);
        lastNameTxt = this.findViewById(R.id.lastNameTxt);

        authenticator = FirebaseAuth.getInstance();
    }

    public void changeBtnPressed(View v)
    {
        String UID = authenticator.getUid();

        String firstNameInput = firstNameTxt.getText().toString();
        String lastNameInput = lastNameTxt.getText().toString();

        DatabaseHandler.changeData(UID, "firstName", firstNameInput);
        DatabaseHandler.changeData(UID, "lastName", lastNameInput);

        this.startActivity(new Intent(this, Soundboard.class));
    }
}
