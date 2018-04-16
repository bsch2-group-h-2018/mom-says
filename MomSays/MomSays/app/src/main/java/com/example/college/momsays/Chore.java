package com.example.college.momsays;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.*;

/**
 * Created by Admin on 04/03/2018.
 */

public class Chore {
    private DatabaseReference mDatabase;

    private String choreKey;
    private String assignedTo;
    private String choreName;
    private String choreDetail;
    private Date choreDate;

    public Chore(){
        mDatabase = FirebaseDatabase.getInstance().getReference();

        choreKey =  mDatabase.push().getKey();
        assignedTo ="childName";
        choreName = "ChoreName" ;
        choreDetail = "Detail of Chores";
        choreDate = new Date();
    }

    public Chore(String assignedTo, String choreName, String choreDetail){
        this.assignedTo = assignedTo;
        this.choreName = choreName;
        this.choreDetail = choreDetail;
    }



    public void writeNewTask (String assignedTo, String choreName, String choreDetail){
        Chore chore = new Chore(assignedTo, choreName, choreDetail);

        mDatabase.child("Chores").child(choreKey).child("Chore_Name").setValue(choreName) ;
        mDatabase.child("Chores").child(choreKey).child("Chore_Detail").setValue(choreDetail) ;
        mDatabase.child("Chores").child(choreKey).child("Assigned_To").setValue(assignedTo) ;
    }

    //Getters and Setters


    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getChoreName() {
        return choreName;
    }

    public void setChoreName(String choreName) {
        this.choreName = choreName;
    }

    public String getChoreDetail() {
        return choreDetail;
    }

    public void setChoreDetail(String choreDetail) {
        this.choreDetail = choreDetail;
    }
}

