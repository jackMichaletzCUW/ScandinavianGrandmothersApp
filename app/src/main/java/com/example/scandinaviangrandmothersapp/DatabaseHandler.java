package com.example.scandinaviangrandmothersapp;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DatabaseHandler
{
    // SINGLETON

    private static FirebaseDatabase database;
    private static DatabaseReference dbRef;

    private static User tempUser;

    public static void initializeDatabase()
    {
        database = FirebaseDatabase.getInstance();
        dbRef = database.getReference("USERS");
    }

    public static void addUserToDB(User input, String pk)
    {
        dbRef.child(pk).setValue(input);
    }

    public static User getUserByPK(String pk)
    {
        dbRef.child(pk).addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                tempUser = dataSnapshot.getValue(User.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });

        return tempUser;
    }

    public static void changeData(String pk, String field, String value)
    {
        dbRef.child(pk).child(field).setValue(value);
    }
}
