package com.example.college.momsays;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.*;

/**
 * Created by Penuel and Jodeyne 04/03/2018.
 */

// This class will be used as Chore object
public class Chore {
    private DatabaseReference mDatabase;

    private String choreKey;
    private String Assigned_To;
    private String Chore_Name;
    private String Chore_Detail;
    private Date choreDate;

    public Chore(){
        mDatabase = FirebaseDatabase.getInstance().getReference();

        choreKey =  mDatabase.push().getKey();
        Assigned_To ="childName";
        Chore_Name = "ChoreName" ;
        Chore_Detail = "Detail of Chores";
        choreDate = new Date();
    }

    public Chore(String Assigned_To, String Chore_Name, String Chore_Detail){
        this.Assigned_To = Assigned_To;
        this.Chore_Name = Chore_Name;
        this.Chore_Detail = Chore_Detail;
    }

    //Getters created by Jodeyne
    public String getAssigned_To() {
        return Assigned_To;
    }

    public void setAssigned_To(String assigned_To) {
        this.Assigned_To = assigned_To;
    }

    public String getChore_Name() {
        return Chore_Name;
    }

    public void setChore_Name(String chore_Name) {
        this.Chore_Name = chore_Name;
    }

    public String getChore_Detail() {
        return Chore_Detail;
    }

    public void setChore_Detail(String chore_Detail) {
        this.Chore_Detail = chore_Detail;
    }

    public Date getChoreDate() {
        return choreDate;
    }

    public void setChoreDate(Date choreDate) {
        this.choreDate = choreDate;
    }

    // This method is created by Penuel
    // Assigns value to the database
    public void writeNewTask (String assignedTo, String choreName, String choreDetail){
        Chore chore = new Chore(assignedTo, choreName, choreDetail);

        mDatabase.child("Chores").child(choreKey).child("Chore_Name").setValue(choreName) ;
        mDatabase.child("Chores").child(choreKey).child("Chore_Detail").setValue(choreDetail) ;
        mDatabase.child("Chores").child(choreKey).child("Assigned_To").setValue(assignedTo) ;
    }
}

