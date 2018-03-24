package com.example.college.momsays;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Admin on 20/03/2018.
 */

public class ListChores extends AppCompatActivity {

     private DatabaseReference mDatabase;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list_chores);

            mDatabase = FirebaseDatabase.getInstance().getReference();

        }

}