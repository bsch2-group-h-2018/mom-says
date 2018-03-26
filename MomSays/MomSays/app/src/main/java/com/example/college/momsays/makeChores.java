package com.example.college.momsays;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class makeChores extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private Chores myChores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_chores);

        mDatabase = FirebaseDatabase.getInstance().getReference();



        Map<String, Object> choreValues = myChores.toMap();
        Map<String, Object> childUpdates = new HashMap<>();

        Button createChoreBT = (Button) findViewById(R.id.createChoreBT);
        createChoreBT.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                //editText.getText().clear();


                EditText assignedToTF = (EditText) findViewById(R.id.assignedToTF);
                EditText choreNameTF = (EditText) findViewById(R.id.choreNameTF);
                EditText choreDetailTF = (EditText) findViewById(R.id.choreDetailTF);


                String newAssignedTo = assignedToTF.getText().toString();
                String newChoreName = choreNameTF.getText().toString();
                String newChoreDetail = choreDetailTF.getText().toString();





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
