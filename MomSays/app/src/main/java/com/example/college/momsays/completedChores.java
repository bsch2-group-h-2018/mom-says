package com.example.college.momsays;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class completedChores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_chores);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
