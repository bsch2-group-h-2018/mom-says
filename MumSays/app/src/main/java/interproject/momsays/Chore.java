package interproject.momsays;
import java.util.*;

/**
 * Created by Admin on 04/03/2018.
 */

public class Chore {
    private String choreId;
    private String assignedTo;
    private String choreName;
    private String choreDetail;
    private Date choreDate;

    public Chore(){
        choreId = "chore00";
        assignedTo ="childName";
        choreName = "ChoreName" ;
        choreDetail = "Detail of Chores";
        choreDate = new Date();
    }

    public Chore(String choreId, String assignedTo, String choreName, String choreDetail, Date choreDate){
        this.choreId = choreId ;
        this.assignedTo = assignedTo;
        this.choreName = choreName;
        this.choreDetail = choreDetail;
        this.choreDate = choreDate;
    }
}

