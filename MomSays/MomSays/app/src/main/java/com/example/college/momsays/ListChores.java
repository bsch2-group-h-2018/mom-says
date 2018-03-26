package com.example.college.momsays;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Admin on 20/03/2018.
 */

public class ListChores extends AppCompatActivity {

     private DatabaseReference mDatabase;
     private DatabaseReference myRef;
     private TextView displayData;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list_chores);

            mDatabase = FirebaseDatabase.getInstance().getReference();
            myRef = mDatabase.child("Chores");

            displayData = (TextView) findViewById(R.id.display_list_TV);

            myRef.child("Chores").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    String value = dataSnapshot.getValue(String.class);

                    displayData.setText(value);

                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value

                }
            });

        }




}