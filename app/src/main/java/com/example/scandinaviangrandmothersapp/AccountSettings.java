package com.example.scandinaviangrandmothersapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class AccountSettings extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);
    }

    public void changeEmailBtnPressed(View v)
    {
        this.startActivity(new Intent(this, ChangeEmail.class));
    }

    public void changeNameBtnPressed(View v)
    {
        this.startActivity(new Intent(this, ChangeName.class));
    }

    public void signOutBtnPressed(View v)
    {
        FirebaseAuth.getInstance().signOut();

        this.startActivity(new Intent(this, MainActivity.class));
    }
}
