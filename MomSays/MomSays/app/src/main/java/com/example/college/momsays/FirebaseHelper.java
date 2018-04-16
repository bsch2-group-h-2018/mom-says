package com.example.college.momsays;

/**
 * Created by Admin on 16/04/2018.
 */


import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;


import java.util.ArrayList;


public class FirebaseHelper {

    DatabaseReference db;
    Boolean saved;
    ArrayList<Chore> chores =new ArrayList<>();

    /*
 PASS DATABASE REFRENCE
  */
    public FirebaseHelper(DatabaseReference db) {
        this.db = db;
    }
    //WRITE IF NOT NULL
    public Boolean save(Chore chore)
    {
        if(chore==null)
        {
            saved=false;
        }else
        {
            try
            {
                db.child("Chore").push().setValue(chores);
                saved=true;

            }catch (DatabaseException e)
            {
                e.printStackTrace();
                saved=false;
            }
        }

        return saved;
    }

    //IMPLEMENT FETCH DATA AND FILL ARRAYLIST
    private void fetchData(DataSnapshot dataSnapshot)
    {
        chores.clear();

        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            Chore chore = ds.getValue(Chore.class);
            chores.add(chore);
        }
    }

    //RETRIEVE
    public ArrayList<Chore> retrieve()
    {
        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return chores;
    }

}