package interproject.momsays;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private Button mSendData;
    //private Firebase mRef;
    private DatabaseReference mDatabase;
    private Chore myChore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        myChore = new Chore();


        Button addBtn = (Button) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText choreIdTF = (EditText) findViewById(R.id.choreIdTF);
                EditText assignedToTF = (EditText) findViewById(R.id.assignedToTF);
                EditText choreNameTF = (EditText) findViewById(R.id.choreNameTF);
                EditText choreDetailTF = (EditText) findViewById(R.id.choreDetailTF);

               String newChoreId = choreIdTF.getText().toString();
                String newAssignedTo = assignedToTF.getText().toString();
                String newChoreName = choreNameTF.getText().toString();
                String newChoreDetail = choreDetailTF.getText().toString();

               myChore.writeNewTask(newChoreId, newAssignedTo, newChoreName,newChoreDetail);

            }
        });

    }
}
