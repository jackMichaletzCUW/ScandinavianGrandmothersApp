package com.example.scandinaviangrandmothersapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Soundboard extends AppCompatActivity
{
    private FirebaseAuth authenticator;

    private Button
        airplane,
        alrightso,
        aye,
        bloodbath,
        dualshield,
        evillaugh,
        fatty,
        gonbestupid,
        goryscene,
        idont,
        locklair,
        programming,
        shutup,
        someonedie,
        windows,
        wrongwithme,
        yarnandcricket;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soundboard);

        authenticator = FirebaseAuth.getInstance();
        //Toast.makeText(this, String.format("%s %s", authenticator.getCurrentUser().getEmail(), authenticator.getCurrentUser().getUid()), Toast.LENGTH_LONG).show();

        MediaPlayer gongMp = MediaPlayer.create(this, R.raw.gong);
        gongMp.start();

        airplane = this.findViewById(R.id.airplane);
        alrightso = this.findViewById(R.id.alrightso);
        aye = this.findViewById(R.id.aye);
        bloodbath = this.findViewById(R.id.bloodbath);
        dualshield = this.findViewById(R.id.dualshield);
        evillaugh = this.findViewById(R.id.evillaugh);
        fatty = this.findViewById(R.id.fatty);
        gonbestupid = this.findViewById(R.id.gonbestupid);
        goryscene = this.findViewById(R.id.goryscene);
        idont = this.findViewById(R.id.idont);
        locklair = this.findViewById(R.id.locklair);
        programming = this.findViewById(R.id.programming);
        shutup = this.findViewById(R.id.shutup);
        someonedie = this.findViewById(R.id.someonedie);
        windows = this.findViewById(R.id.windows);
        wrongwithme = this.findViewById(R.id.wrongwithme);
        yarnandcricket = this.findViewById(R.id.yarnandcricket);

        final MediaPlayer airplaneMp = MediaPlayer.create(this, R.raw.airplane);
        final MediaPlayer alrightsoMp = MediaPlayer.create(this, R.raw.alrightso);
        final MediaPlayer ayeMP = MediaPlayer.create(this, R.raw.aye);
        final MediaPlayer bloodbathMp = MediaPlayer.create(this, R.raw.bloodbath);
        final MediaPlayer dualshieldMp = MediaPlayer.create(this, R.raw.dualshield);
        final MediaPlayer evillaughMp = MediaPlayer.create(this, R.raw.evillaugh);
        final MediaPlayer fattyMp = MediaPlayer.create(this, R.raw.fatty);
        final MediaPlayer gonbestupidMp = MediaPlayer.create(this, R.raw.gonbestupid);
        final MediaPlayer gorysceneMp = MediaPlayer.create(this, R.raw.goryscene);
        final MediaPlayer idontMp = MediaPlayer.create(this, R.raw.idont);
        final MediaPlayer locklairMp = MediaPlayer.create(this, R.raw.locklair);
        final MediaPlayer programmingMp = MediaPlayer.create(this, R.raw.programming);
        final MediaPlayer shutupMp = MediaPlayer.create(this, R.raw.shutup);
        final MediaPlayer someonedieMp = MediaPlayer.create(this, R.raw.someonedie);
        final MediaPlayer windowsMp = MediaPlayer.create(this, R.raw.windows);
        final MediaPlayer wrongwithmeMp = MediaPlayer.create(this, R.raw.wrongwithme);
        final MediaPlayer yarnandcricketMp = MediaPlayer.create(this, R.raw.yarnandcricket);

        airplane.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                airplaneMp.start();
            }
        });

        alrightso.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                alrightsoMp.start();
            }

        });

        aye.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                ayeMP.start();
            }

        });

        bloodbath.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                bloodbathMp.start();
            }

        });

        dualshield.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                dualshieldMp.start();
            }

        });

        evillaugh.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                evillaughMp.start();
            }

        });

        fatty.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                fattyMp.start();
            }

        });

        gonbestupid.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                gonbestupidMp.start();
            }

        });

        goryscene.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                gorysceneMp.start();
            }

        });

        idont.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                idontMp.start();
            }

        });

        locklair.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                locklairMp.start();
            }

        });

        programming.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                programmingMp.start();
            }

        });

        shutup.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                shutupMp.start();
            }

        });

        someonedie.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                someonedieMp.start();
            }

        });

        windows.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                windowsMp.start();
            }

        });

        wrongwithme.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                wrongwithmeMp.start();
            }

        });

        yarnandcricket.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                yarnandcricketMp.start();
            }

        });
    }

    public void settingsBtnPressed(View v)
    {
        this.startActivity(new Intent(this, AccountSettings.class));
    }
}
