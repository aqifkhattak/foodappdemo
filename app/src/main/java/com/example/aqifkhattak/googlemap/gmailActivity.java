package com.example.aqifkhattak.googlemap;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class gmailActivity extends AppCompatActivity {
    private EditText eTo;
    private EditText eSubject;
    private EditText eMsg;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gmail);
        eTo = (EditText)findViewById(R.id.txtTo);
        eSubject = (EditText)findViewById(R.id.txtSub);
        eMsg = (EditText)findViewById(R.id.txtMsg);
        btn = (Button)findViewById(R.id.btnSend);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String to = eTo.getText().toString().trim();
                String subject = eSubject.getText().toString().trim();
                String messg = eMsg.getText().toString().trim();
                if(subject.equals("") && messg.equals(""))
                {
                    Toast.makeText(gmailActivity.this, "Enter message please", Toast.LENGTH_SHORT).show();
                }
                else {
                    Log.i("Send email", "");
                    String[] TO = {"aqibkhattak316@gmail.com"};
                    Intent emailIntent = new Intent(Intent.ACTION_SEND);
                    emailIntent.setData(Uri.parse("mailto:"));
                    emailIntent.setType("text/plain");
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                    emailIntent.putExtra(Intent.EXTRA_TEXT, messg);

                    try {
                        startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                        finish();
                        Log.i("Finished sending", "");
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(gmailActivity.this,
                                "There is no email client installed.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
