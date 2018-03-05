package interproject.momsays;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class makeChores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_chores);

        Spinner newChoreSpinner = (Spinner) findViewById(R.id.newChoreSpinner);

        ArrayAdapter<String> newChoreAdapter = new ArrayAdapter<>(makeChores.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.newChore));
        newChoreAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        newChoreSpinner.setAdapter(newChoreAdapter);
    }
}
