package com.example.college.momsays;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public  class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView Reg_TV ;
    private Button login_btn ;
    private EditText editText ;
    private EditText editText4 ;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Reg_TV = (TextView) findViewById(R.id.Reg_TV);
        login_btn = (Button) findViewById(R.id.login_btn);
        editText = (EditText) findViewById(R.id.editText);
        editText4 = (EditText) findViewById(R.id.editText4);


        login_btn.setOnClickListener(this);
        Reg_TV.setOnClickListener(this);
        progressDialog = new ProgressDialog(this);


    }



    @Override
    public void onClick(View view) {

        if (view == login_btn){
            startActivity(new Intent(this, homePage.class));
        }


        if (view == Reg_TV) {
            finish();
            startActivity(new Intent(this, NewUser.class));
        }
    }
}
