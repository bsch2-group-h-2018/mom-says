package com.example.college.momsays;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.FirebaseDatabase;

import java.util.*;

/**
 * Created by Admin on 04/03/2018.
 */

public class Chores {
    private DatabaseReference mDatabase;

    public String choreKey;
    public String assignedTo;
    public String choreName;
    public String choreDetail;



    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("assignedTo", assignedTo);
        result.put("choreNAme", choreName);
        result.put("choreDetail", choreDetail);

        return result;
    }
}

