package com.example.college.momsays;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[]chore_item = {"chore 1", "chore 2", "chore 3"};
        ListAdapter choreAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, chore_item);
        ListView mListView = (ListView) findViewById(R.id.chore_list_view);
        mListView.setAdapter(choreAdapter);


        Button btnToSecond = (Button) findViewById(R.id.login_btn);

        btnToSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, homePage.class);
                startActivity(intent);
            }
        });


    }
}
