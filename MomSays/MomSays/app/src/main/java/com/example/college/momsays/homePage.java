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
        setContentView(R.layout.activity_give_chores);
        setContentView(R.layout.activity_home_page);
        /*setContentView(R.layout.activity_make_chores);*/

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


        //This is gonna be Test 1 Button.
        Button btnTest_1 = (Button) findViewById(R.id.test1_BTN);

        btnTest_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(homePage.this, Main_Act_2.class);
                startActivity(intent);
            }
        } );

    }
}
