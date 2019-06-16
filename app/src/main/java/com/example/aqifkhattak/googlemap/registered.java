package com.example.aqifkhattak.googlemap;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registered extends AppCompatActivity {
private TextView sinin;
private EditText nametext,passtext,cpass;
private Button savedata;
private FirebaseAuth firebaseAuth;
    private ProgressDialog mProgress;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);
        sinin = (TextView)findViewById(R.id.sinintext);
        nametext = (EditText) findViewById(R.id.emailid);
        passtext = (EditText)findViewById(R.id.passid);
        cpass = (EditText)findViewById(R.id.con);
        mProgress =new ProgressDialog(this);
        String titleId="Signing in...";
        mProgress.setTitle(titleId);
        mProgress.setMessage("Please Wait...");
        firebaseAuth = FirebaseAuth.getInstance();
        savedata = (Button)findViewById(R.id.sininbutton);
        savedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mProgress.show();
                String namefield = nametext.getText().toString().trim();
                String passfield = passtext.getText().toString().trim();
                String confield = cpass.getText().toString().trim();
                if (passfield != (confield)) {
                    Toast.makeText(registered.this, "password no match", Toast.LENGTH_SHORT).show();
                }
                if (passfield.equals("")) {
                    Toast.makeText(registered.this, "Enter password ...", Toast.LENGTH_SHORT).show();
                }
                if (namefield.equals("")) {
                    Toast.makeText(registered.this, "Enter email ...", Toast.LENGTH_SHORT).show();

                } else {

                    firebaseAuth.createUserWithEmailAndPassword(namefield, passfield).addOnCompleteListener(registered.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                mProgress.dismiss();

                                Toast.makeText(registered.this, "saved", Toast.LENGTH_SHORT).show();

                            } else {
                                mProgress.dismiss();
                                Toast.makeText(registered.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }

                    });
                }
            }
        });
        sinin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logina = new Intent(getApplicationContext(),loginActivity.class);
                startActivity(logina);
            }
        });

    }
}
