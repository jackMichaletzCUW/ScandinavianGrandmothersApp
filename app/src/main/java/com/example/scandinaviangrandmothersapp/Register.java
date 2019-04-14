package com.example.scandinaviangrandmothersapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    private final int BAD_COLOR = 0xFFFF6969; // pastel red
    private final int GOOD_COLOR = 0xFFFFFFFF; // white

    private EditText firstNameTxt, lastNameTxt, emailTxt;
    private EditText passwordTxt, confirmPasswordTxt;
    private EditText securityAnswer1, securityAnswer2, securityAnswer3;

    private Spinner securitySpinner1, securitySpinner2, securitySpinner3;

    private ArrayAdapter<String> spinner1AA, spinner2AA, spinner3AA;

    private String[] allSecurityOptions = {
        "What is your favorite pet's name?",
        "What is your hometown?",
        "What is your password?",
        "What is your favorite movie?",
        "Who is your favorite CS department professor?",
        "What is mother's maiden name?"
    };

    private String[] security1Options = new String[allSecurityOptions.length - 2];
    private String[] security2Options = new String[allSecurityOptions.length - 2];
    private String[] security3Options = new String[allSecurityOptions.length - 2];

    private int spinner1Selection = 0;
    private int spinner2Selection = 1;
    private int spinner3Selection = 2;

    private Button registerBtn;

    //private FirebaseDatabase database;
    private FirebaseAuth authenticator;
    //private DatabaseReference dbRef;

    private User registeringUser;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firstNameTxt = this.findViewById(R.id.firstNameTxt);
        lastNameTxt = this.findViewById(R.id.lastNameTxt);
        emailTxt = this.findViewById(R.id.emailTxt);

        passwordTxt = this.findViewById(R.id.passwordTxt);
        confirmPasswordTxt = this.findViewById(R.id.confirmPasswordTxt);

        securityAnswer1 = this.findViewById(R.id.securityAnswer1);
        securityAnswer2 = this.findViewById(R.id.securityAnswer2);
        securityAnswer3 = this.findViewById(R.id.securityAnswer3);

        securitySpinner1 = this.findViewById(R.id.securitySpinner1);
        securitySpinner2 = this.findViewById(R.id.securitySpinner2);
        securitySpinner3 = this.findViewById(R.id.securitySpinner3);

        this.computeSpinnerArrays();

        spinner1AA = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, security1Options);
        spinner2AA = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, security2Options);
        spinner3AA = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, security3Options);

        spinner1AA.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner2AA.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner3AA.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        securitySpinner1.setAdapter(spinner1AA);
        securitySpinner2.setAdapter(spinner2AA);
        securitySpinner3.setAdapter(spinner3AA);

        securitySpinner1.setOnItemSelectedListener(this);
        securitySpinner2.setOnItemSelectedListener(this);
        securitySpinner3.setOnItemSelectedListener(this);

        registerBtn = this.findViewById(R.id.registerBtn);

        // Initialize the database
        //database = FirebaseDatabase.getInstance();
        authenticator = FirebaseAuth.getInstance();
        //dbRef = database.getReference("USERS");

        authenticator.signOut();

        authenticator.addAuthStateListener(new FirebaseAuth.AuthStateListener()
        {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth)
            {
                if(firebaseAuth.getUid() != null)
                {
                    //dbRef.child(firebaseAuth.getUid()).setValue(registeringUser);
                    DatabaseHandler.addUserToDB(registeringUser, firebaseAuth.getUid());
                    Register.super.startActivity(new Intent(Register.this, Soundboard.class));
                }
            }
        });
    }

    private void computeSpinnerArrays()
    {
        for(int ac = 0; ac < allSecurityOptions.length; ac++)
        {
            if(securitySpinner1.getSelectedItemPosition() != -1 && security1Options[securitySpinner1.getSelectedItemPosition()].equals(allSecurityOptions[ac]))
            {
                spinner1Selection = ac;
            }
            else if(securitySpinner2.getSelectedItemPosition() != -1 && security2Options[securitySpinner2.getSelectedItemPosition()].equals(allSecurityOptions[ac]))
            {
                spinner2Selection = ac;
            }
            else if(securitySpinner3.getSelectedItemPosition() != -1 && security3Options[securitySpinner3.getSelectedItemPosition()].equals(allSecurityOptions[ac]))
            {
                spinner3Selection = ac;
            }
        }

        int s1c = 0;
        int s2c = 0;
        int s3c = 0;

        for(int ac = 0; ac < allSecurityOptions.length; ac++)
        {
            if(ac != spinner2Selection && ac != spinner3Selection)
            {
                security1Options[s1c] = allSecurityOptions[ac];
                s1c++;
            }

            if(ac != spinner1Selection && ac != spinner3Selection)
            {
                security2Options[s2c] = allSecurityOptions[ac];
                s2c++;
            }

            if(ac != spinner1Selection && ac != spinner2Selection)
            {
                security3Options[s3c] = allSecurityOptions[ac];
                s3c++;
            }
        }
    }

    public void firstNameTxtClicked(View v)
    {
        // Change the color back to white
        firstNameTxt.setBackgroundColor(GOOD_COLOR);
    }

    public void lastNameTxtClicked(View v)
    {
        // Change the color back to white
        lastNameTxt.setBackgroundColor(GOOD_COLOR);
    }

    public void emailTxtClicked(View v)
    {
        // Change the color back to white
        emailTxt.setBackgroundColor(GOOD_COLOR);
    }

    public void passwordTxtClicked(View v)
    {
        // Change the color back to white
        passwordTxt.setBackgroundColor(GOOD_COLOR);
    }

    public void confirmPasswordTxtClicked(View v)
    {
        // Change the color back to white
        confirmPasswordTxt.setBackgroundColor(GOOD_COLOR);
    }

    public void securityAnswer1Clicked(View v)
    {
        // Change the color back to white
        securityAnswer1.setBackgroundColor(GOOD_COLOR);
    }

    public void securityAnswer2Clicked(View v)
    {
        // Change the color back to white
        securityAnswer2.setBackgroundColor(GOOD_COLOR);
    }

    public void securityAnswer3Clicked(View v)
    {
        // Change the color back to white
        securityAnswer3.setBackgroundColor(GOOD_COLOR);
    }

    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
    {
        this.computeSpinnerArrays();
    }

    public void onNothingSelected(AdapterView<?> parentView)
    {

    }

    public void createUserInFirebase(String email, String password)
    {
        authenticator.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {

            }
        });
    }

    public void registerBtnClicked(View v)
    {
        // Get data
        String firstNameInput = firstNameTxt.getText().toString();
        String lastNameInput = lastNameTxt.getText().toString();
        String emailInput = emailTxt.getText().toString();
        String passwordInput = passwordTxt.getText().toString();
        String confirmPasswordInput = confirmPasswordTxt.getText().toString();
        String securityAnswer1Input = securityAnswer1.getText().toString();
        String securityAnswer2Input = securityAnswer2.getText().toString();
        String securityAnswer3Input = securityAnswer3.getText().toString();

        boolean validData = true;

        if(firstNameInput == null)
        {
            validData = false;
            firstNameTxt.setBackgroundColor(BAD_COLOR);
        }

        if(lastNameInput == null)
        {
            validData = false;
            lastNameTxt.setBackgroundColor(BAD_COLOR);
        }

        if(emailInput == null)
        {
            validData = false;
            emailTxt.setBackgroundColor(BAD_COLOR);
        }

        if(passwordInput == null)
        {
            validData = false;
            passwordTxt.setBackgroundColor(BAD_COLOR);
        }

        if(passwordInput.length() < 6)
        {
            validData = false;
            passwordTxt.setBackgroundColor(BAD_COLOR);
        }

        if(confirmPasswordInput == null)
        {
            validData = false;
            confirmPasswordTxt.setBackgroundColor(BAD_COLOR);
        }

        if(!confirmPasswordInput.equals(passwordInput))
        {
            // Passwords don't match
            validData = false;
            passwordTxt.setBackgroundColor(BAD_COLOR);
            confirmPasswordTxt.setBackgroundColor(BAD_COLOR);
        }

        if(securityAnswer1Input == null)
        {
            validData = false;
            securityAnswer1.setBackgroundColor(BAD_COLOR);
        }

        if(securityAnswer2Input == null)
        {
            validData = false;
            securityAnswer2.setBackgroundColor(BAD_COLOR);
        }

        if(securityAnswer3Input == null)
        {
            validData = false;
            securityAnswer3.setBackgroundColor(BAD_COLOR);
        }

        if(validData)
        {
            // Create User object
            registeringUser = new User(firstNameInput, lastNameInput, emailInput, passwordInput, securityAnswer1Input, securityAnswer2Input, securityAnswer3Input, spinner1Selection, spinner2Selection, spinner3Selection);

            this.createUserInFirebase(emailInput, passwordInput);
        }
    }
}
