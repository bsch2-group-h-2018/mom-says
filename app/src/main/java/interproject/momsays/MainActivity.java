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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Firebase.setAndroidContext(this);

        mSendData = (Button) findViewById(R.id.sendData);
        Button addBtn = (Button) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText nameText = (EditText) findViewById(R.id.nameText);
                EditText numText = (EditText) findViewById(R.id.numText);

                TextView displayTextView = (TextView) findViewById(R.id.displayTextView);

                String nameVar = nameText.getText().toString();
                int numVar = Integer.parseInt(numText.getText().toString());

                displayTextView.setText(nameVar + " " + numVar);
            }
        });


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");


        mSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}
