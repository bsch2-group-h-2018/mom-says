package com.example.admin.attemp2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static com.example.admin.attemp2.R.id.button;

public class MainActivity extends AppCompatActivity {

    Button bt1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = (Button) findViewById(button);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v){

            }
        });
    }
}









