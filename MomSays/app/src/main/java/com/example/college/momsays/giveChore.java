package com.example.college.momsays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


//Jodeyne - class created by
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

            // This methods listens to any updates and changes on the database.
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds: dataSnapshot.getChildren())
                {
                    chore = ds.getValue(Chore.class);
                    list.add("Chore Name:" + chore.getChore_Name() +  "\n " + "Assigned To:" + " "+chore.getAssigned_To() + "\n "+ "Details:" + " " +chore.getChore_Detail());
                    listView.setAdapter(adapter);

                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        }
                    });

                    listView.setOnItemClickListener(
                            //Listener is waiting for user to click something, when they do, it gives you an information on what they click
                            new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    String chore = String.valueOf(parent.getItemAtPosition(position));
                                    Toast.makeText(giveChore.this, chore, Toast.LENGTH_LONG).show();
                                }
                            }

                    );
                }

            }



            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        Button sendButton = (Button) findViewById(R.id.sharenBtn);

        sendButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody ="Chore Name:" + chore.getChore_Name() +  "\n " + "Assigned To:" + " "+chore.getAssigned_To() + "\n "+ "Details:" + " " +chore.getChore_Detail();;
                myIntent.putExtra(Intent.EXTRA_SUBJECT,shareBody);
                myIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
                startActivity(Intent.createChooser(myIntent, "Share Using"));
            }
        });


    }
}
