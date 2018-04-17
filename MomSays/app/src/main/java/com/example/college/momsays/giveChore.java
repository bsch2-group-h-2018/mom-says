package com.example.college.momsays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class giveChore extends AppCompatActivity {

    ListView listView;
    FirebaseDatabase database;
    DatabaseReference ref;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    Chore chore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_chores);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        chore = new Chore();
        listView = (ListView) findViewById(R.id.choreListView);
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Chores");
        list = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, list);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds: dataSnapshot.getChildren())
                {
                    chore = ds.getValue(Chore.class);
                    list.add("Chore Name:" + chore.getChore_Name() +  "\n " + "Assigned To:" + " "+chore.getAssigned_To() + "\n "+ "Details:" + " " +chore.getChore_Detail());
                }
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
       /* Spinner mySpinner = (Spinner) findViewById(R.id.giveChoreSpinner);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(giveChore.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.chores));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);



        Spinner kidSpinner = (Spinner) findViewById(R.id.selectKidSpinner);

        ArrayAdapter<String> kidAdapter = new ArrayAdapter<>(giveChore.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.kids));
        kidAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        kidSpinner.setAdapter(kidAdapter);

        */



        Button sendButton = (Button) findViewById(R.id.sharenBtn);

        sendButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody ="ChoreName";
                String shareSub ="ChoreName";
                myIntent.putExtra(Intent.EXTRA_SUBJECT,shareBody);
                myIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
                startActivity(Intent.createChooser(myIntent, "Share Using"));
            }
        });

    }
}
