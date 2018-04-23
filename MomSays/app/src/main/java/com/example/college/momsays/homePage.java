/**
 * Group H
 * https://github.com/bsch2-group-h-2018/mom-says
 */

package com.example.college.momsays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homePage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_give_chores);
        setContentView(R.layout.activity_home_page);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);


        Button btnToGC = (Button) findViewById(R.id.giveChoresbtn);

        btnToGC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(homePage.this, giveChore.class);
                startActivity(intent);
            }
        } );


        Button btnToMC = (Button) findViewById(R.id.makeChoresbtn);

        btnToMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(homePage.this, makeChores.class);
                startActivity(intent);
            }
        } );

        Button btnToWU = (Button) findViewById(R.id.weeklyUpdatebtn);

        btnToWU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(homePage.this, WeeklyUpdate.class);
                startActivity(intent);
            }
        } );

        Button btnToSettings = (Button) findViewById(R.id.settingsbtn);

        btnToSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(homePage.this, Settings.class);
                startActivity(intent);
            }
        } );

        Button btnToCC = (Button) findViewById(R.id.completedChoresbtn);

        btnToCC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(homePage.this, completedChores.class);
                startActivity(intent);
            }

        } );


    }
}
