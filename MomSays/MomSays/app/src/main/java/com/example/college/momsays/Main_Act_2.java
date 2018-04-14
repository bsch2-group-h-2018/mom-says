package com.example.college.momsays;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Admin on 13/04/2018.
 */

public class Main_Act_2 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bucky_list);

        String[]chore_item = {"chore 1", "chore 2", "chore 3"};
        ListAdapter choreAdapter = new CustomAdapter(this, chore_item);
        ListView chore_list_view = (ListView) findViewById(R.id.chore_list_view);
        chore_list_view.setAdapter(choreAdapter);

        chore_list_view.setOnItemClickListener(
                //Listener is waiting for user to click something, when they do, it gives you an information on what they click
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String chore = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(Main_Act_2.this, chore, Toast.LENGTH_LONG).show();
                    }
                }

        );

    }
}

