package com.example.college.momsays;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class makeChores extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private Chore myChore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_chores);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        myChore = new Chore();

        Button createChoreBT = (Button) findViewById(R.id.createChoreBT);
        createChoreBT.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                final EditText choreIdTF = (EditText) findViewById(R.id.choreIdTF);
                choreIdTF.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       choreIdTF.getText().clear();
                    }
                });

                //editText.getText().clear();


                EditText assignedToTF = (EditText) findViewById(R.id.assignedToTF);
                EditText choreNameTF = (EditText) findViewById(R.id.choreNameTF);
                EditText choreDetailTF = (EditText) findViewById(R.id.choreDetailTF);

                String newChoreId = choreIdTF.getText().toString();
                String newAssignedTo = assignedToTF.getText().toString();
                String newChoreName = choreNameTF.getText().toString();
                String newChoreDetail = choreDetailTF.getText().toString();

                myChore.writeNewTask(newChoreId, newAssignedTo, newChoreName,newChoreDetail);

            }
        });

        /*
        Spinner newChoreSpinner = (Spinner) findViewById(R.id.newChoreSpinner);

        ArrayAdapter<String> newChoreAdapter = new ArrayAdapter<>(makeChores.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.newChore));
        newChoreAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        newChoreSpinner.setAdapter(newChoreAdapter);

        */

    }
}
