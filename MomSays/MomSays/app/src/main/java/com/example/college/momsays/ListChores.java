package com.example.college.momsays;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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

     private DatabaseReference mDatabase;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list_chores);
            final List<Chore> choresList = new ArrayList<Chore>();

            mDatabase = FirebaseDatabase.getInstance().getReference();

            //To be resumed
            mDatabase.child("Chores").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // get all of the children at this level.
                    Iterable<DataSnapshot> children = dataSnapshot.getChildren();

                    // shake hands with each of them.'
                    for (DataSnapshot child : children) {
                        SpecimenDTO specimenDTO = child.getValue(SpecimenDTO.class);
                        specimens.add(specimenDTO);
                    }

            });





        }

}