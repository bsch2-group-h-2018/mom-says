package com.example.college.momsays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class homePage extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_chores);
        setContentView(R.layout.activity_home_page);
        /*setContentView(R.layout.activity_make_chores);*/

             firebaseAuth = FirebaseAuth.getInstance();
             if(firebaseAuth.getCurrentUser()==null) {
                 finish();
                 startActivity(new Intent(this, NewUser.class));
             }
        FirebaseUser user = firebaseAuth.getCurrentUser();

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


    }
}
