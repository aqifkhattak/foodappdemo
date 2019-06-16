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

public class loginActivity extends AppCompatActivity {
private EditText mailtext,passtext;
private Button loginbutton;
private TextView siniptext;
    private ProgressDialog mProgress;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mailtext = (EditText) findViewById(R.id.emailid);
        passtext = (EditText)findViewById(R.id.passid);
        siniptext = (TextView)findViewById(R.id.sinuptext);
        loginbutton = (Button)findViewById(R.id.sininbutton);
        firebaseAuth = FirebaseAuth.getInstance();
        mProgress =new ProgressDialog(this);
        String titleId="Signing in...";
        mProgress.setTitle(titleId);
        mProgress.setMessage("Please Wait...");
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mProgress.show();
                String mailfield = mailtext.getText().toString().trim();
                String passfield = passtext.getText().toString().trim();
                firebaseAuth.signInWithEmailAndPassword(mailfield,passfield).addOnCompleteListener(loginActivity.this, new OnCompleteListener<AuthResult>() {
                  @Override
                  public void onComplete(@NonNull Task<AuthResult> task) {
                      if(task.isSuccessful())
                      {
                          mProgress.dismiss();
                          Intent main = new Intent(getApplicationContext(),Main2Activity
                                  .class);
                          startActivity(main);
                      }
                      else
                      {
                          mProgress.dismiss();
                          Toast.makeText(loginActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                      }

                  }
              });

            }
        });
        siniptext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reg = new Intent(getApplicationContext(),registered.class);
                startActivity(reg);

            }
        });

    }
}
