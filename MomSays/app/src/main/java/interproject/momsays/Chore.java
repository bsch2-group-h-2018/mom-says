package interproject.momsays;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.*;

/**
 * Created by Admin on 04/03/2018.
 */

public class Chore {
    private DatabaseReference mDatabase;

    private String choreId;
    private String assignedTo;
    private String choreName;
    private String choreDetail;
    private Date choreDate;

    public Chore(){
        mDatabase = FirebaseDatabase.getInstance().getReference();

        choreId = "chore00";
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

    public void writeNewTask (String choreId, String assignedTo, String choreName, String choreDetail){
        Chore chore = new Chore(assignedTo, choreName, choreDetail);

        mDatabase.child("Chores").child(choreId).child("Assigned_To").setValue(assignedTo) ;
        mDatabase.child("Chores").child(choreId).child("Chore_Name").setValue(choreName) ;
        mDatabase.child("Chores").child(choreId).child("Chore_Detail").setValue(choreDetail) ;
    }
}

