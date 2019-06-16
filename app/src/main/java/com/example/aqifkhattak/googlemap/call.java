package com.example.aqifkhattak.googlemap;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class call extends AppCompatActivity {
private EditText input;
private Button call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        input = (EditText)findViewById(R.id.calltext);
        call = (Button)findViewById(R.id.callbutton);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNo = input.getText().toString();

                if(phoneNo.length()>11 || phoneNo.length()<11)
                {
                    Toast.makeText(call.this, "Enter valied  number", Toast.LENGTH_SHORT).show();

                }

                  else if (!TextUtils.isEmpty(phoneNo))
                {
                    String dial = "03499035712:" + phoneNo;
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
                }
                 else {
                    Toast.makeText(call.this, "Enter a phone number", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
