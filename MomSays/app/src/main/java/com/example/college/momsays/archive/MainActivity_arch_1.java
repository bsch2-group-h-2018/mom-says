package com.example.college.momsays.archive;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.college.momsays.R;
import com.example.college.momsays.homePage;
import com.google.firebase.auth.FirebaseAuth;

public  class MainActivity_arch_1 extends AppCompatActivity implements View.OnClickListener {

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


        login_btn = (Button) findViewById(R.id.login_btn);
        editText = (EditText) findViewById(R.id.editText);
        editText4 = (EditText) findViewById(R.id.editText4);

        firebaseAuth = FirebaseAuth.getInstance();

        login_btn.setOnClickListener(this);
        Reg_TV.setOnClickListener(this);
        progressDialog = new ProgressDialog(this);


    }

    public void userLogin() {
        String email = editText.getText().toString().trim();
        String password = editText4.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            // email is empty
            Toast.makeText(this, "Please enter Email", Toast.LENGTH_SHORT).show();

            return;
        }
        if (TextUtils.isEmpty(password)) {
            //password id empty

            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();

            return;

        }

        progressDialog.setMessage("Registering User .... ");
        progressDialog.show();



    }

    @Override
    public void onClick(View view) {

        if (view == login_btn){
            startActivity(new Intent(this, homePage.class));
        }


        if (view == login_btn) {
            userLogin();
        }


        if (view == login_btn){
            finish();
            startActivity(new Intent(this, homePage.class));
        }


    }
}
