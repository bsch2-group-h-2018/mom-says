package com.example.college.momsays;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Admin on 20/03/2018.
 */

public class ListChores extends AppCompatActivity {

     private DatabaseReference databaseRefernce;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list_chores);

            final List<Chore> chore = new ArrayList<Chore>();

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = database.getReference();
            databaseReference.child("Chores").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Iterable<DataSnapshot> children = dataSnapshot.getChildren();

                    for (DataSnapshot child : children){
                        Chore chore = child.getValue(Chore.class);
                        Chores.add(chore);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });



        }

}