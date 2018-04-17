package com.example.college.momsays;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WeeklyUpdate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_update);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
