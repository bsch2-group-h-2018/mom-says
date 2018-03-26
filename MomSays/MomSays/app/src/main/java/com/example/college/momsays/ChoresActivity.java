package com.example.college.momsays;

/**
 * Created by Admin on 26/03/2018.
 */
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChoresActivity extends AppCompatActivity{
    private static final String TAG = "ChoreActivity";
    private static final String REQUIRED = "Required";

    private Button btnBack;
    private Button btnSend;
    private EditText edtSentText;
    private TextView tvAuthor;
    private TextView tvTime;
    private TextView tvBody;

    private DatabaseReference mDatabase;
    private DatabaseReference mChoresReference;
    private ChildEventListener mChoresListener;

    private ArrayList<Chores> choreList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chores);

        btnSend = (Button) findViewById(R.id.btn_send);
        btnBack = (Button) findViewById(R.id.btn_back);
        edtSentText = (EditText) findViewById(R.id.edt_sent_text);
        tvAuthor = (TextView) findViewById(R.id.tv_author);
        tvTime = (TextView) findViewById(R.id.tv_time);
        tvBody = (TextView) findViewById(R.id.tv_body);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mChoresReference = FirebaseDatabase.getInstance().getReference("chores");


        choreList = new ArrayList<>();

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitChores();
                edtSentText.setText("");
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tvAuthor.setText("");
        tvTime.setText("");
        tvBody.setText("");
    }

    @Override
    protected void onStart() {
        super.onStart();

        ChildEventListener childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
                // A new message has been added
                // onChildAdded() will be called for each node at the first time
                Chores chores = dataSnapshot.getValue(Chores.class);
                choreList.add(chores);

                Log.e(TAG, "onChildAdded:" + chores.choreName);

                Chores latest = choreList.get(choreList.size() - 1);

                tvAuthor.setText(latest.assignedTo);
                tvTime.setText(latest.choreDetail);
                tvBody.setText(latest.choreName);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {
                Log.e(TAG, "onChildChanged:" + dataSnapshot.getKey());

                // A message has changed
                Chores chores = dataSnapshot.getValue(Chores.class);
                Toast.makeText(ChoresActivity.this, "onChildChanged: " + chores.choreName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Log.e(TAG, "onChildRemoved:" + dataSnapshot.getKey());

                // A message has been removed
                Chores chores = dataSnapshot.getValue(Chores.class);
                Toast.makeText(ChoresActivity.this, "onChildRemoved: " + chores.choreName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {
                Log.e(TAG, "onChildMoved:" + dataSnapshot.getKey());

                // A message has changed position
                Chores chores = dataSnapshot.getValue(Chores.class);
                Toast.makeText(ChoresActivity.this, "onChildMoved: " + chores.choreName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "postMessages:onCancelled", databaseError.toException());
                Toast.makeText(ChoresActivity.this, "Failed to load Chores.", Toast.LENGTH_SHORT).show();
            }
        };

        mChoresReference.addChildEventListener(childEventListener);

        // copy for removing at onStop()
        mChoresListener = childEventListener;
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (mChoresListener != null) {
            mChoresReference.removeEventListener(mChoresListener);
        }

        for (Chores chores: choreList) {
            Log.e(TAG, "listItem: " + chores.choreName);
        }
    }

    private void submitChores() {
        final String body = edtSentText.getText().toString();

        if (TextUtils.isEmpty(body)) {
            edtSentText.setError(REQUIRED);
            return;
        }


    }

    private void writeNewChores(String assignedTo, String choreName, String choreDetail) {
        Chores chores = new Chores(assignedTo, choreName, choreDetail);

        Map<String, Object> choreValues = chores.toMap();
        Map<String, Object> childUpdates = new HashMap<>();

        String key = mDatabase.child("messages").push().getKey();

        childUpdates.put("/messages/" + key, choreValues);

        mDatabase.updateChildren(childUpdates);
    }


}

