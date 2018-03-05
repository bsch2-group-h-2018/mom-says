package interproject.momsays;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class giveChore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_chores);

        Spinner mySpinner = (Spinner) findViewById(R.id.giveChoreSpinner);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(giveChore.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.chores));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);



        Spinner kidSpinner = (Spinner) findViewById(R.id.selectKidSpinner);

        ArrayAdapter<String> kidAdapter = new ArrayAdapter<>(giveChore.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.kids));
        kidAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        kidSpinner.setAdapter(kidAdapter);

    }
}
