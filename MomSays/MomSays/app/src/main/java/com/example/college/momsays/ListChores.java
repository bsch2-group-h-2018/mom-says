package com.example.college.momsays;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
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
            final List<Chore> choreList = new ArrayList<Chore>();

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = database.getReference();

            //To be resumed
            databaseReference.child("Chores").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // get all of the children at this level.
                    Iterable<DataSnapshot> children = dataSnapshot.getChildren();

                    // shake hands with each of them.'
                    for (DataSnapshot child : children) {
                        Chore chore = child.getValue(Chore.class);
                        choreList.add(chore);
                    }


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "loadPost:onCancelled", databaseError.toException());

                }

            });

            // Make an ArrayAdapter to show our results.
            ArrayAdapter<Chore> choreArrayAdapter = new ArrayAdapter<Chore>(getActivity(), android.R.layout.simple_list_item_1, choreList);

            // set this specimen list in the fragment
            setListAdapter(plantAdapter);

        }

}