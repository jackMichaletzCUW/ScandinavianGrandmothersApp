package com.example.scandinaviangrandmothersapp;

import java.io.Serializable;

public class User implements Serializable
{
    public String ID;

    public String email;
    public String password;
    public String firstName;
    public String lastName;

    public String securityAnswer1;
    public String securityAnswer2;
    public String securityAnswer3;

    public int securityChoice1;
    public int securityChoice2;
    public int securityChoice3;

    public User()
    {
        ID = "NULL";

        email = "NULL";
        firstName = "NULL";
        lastName = "NULL";
        password = "NULL";

        securityAnswer1 = "NULL";
        securityAnswer2 = "NULL";
        securityAnswer3 = "NULL";

        securityChoice1 = -1;
        securityChoice2 = -1;
        securityChoice3 = -1;
    }

    public User(String firstName, String lastName, String email, String password, String securityAnswer1, String securityAnswer2, String securityAnswer3, int securityChoice1, int securityChoice2, int securityChoice3)
    {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;

        this.password = password;

        this.securityAnswer1 = securityAnswer1;
        this.securityAnswer2 = securityAnswer2;
        this.securityAnswer3 = securityAnswer3;

        this.securityChoice1 = securityChoice1;
        this.securityChoice2 = securityChoice2;
        this.securityChoice3 = securityChoice3;
    }
}
