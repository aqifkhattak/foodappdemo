package com.example.aqifkhattak.googlemap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
private LinearLayout imageView;
private LinearLayout gmail,callview;
private LinearLayout details,shareidd,list;

private  ImageView location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView = (LinearLayout)findViewById(R.id.mapid);
        gmail = (LinearLayout)findViewById(R.id.gmailid);
        details = (LinearLayout) findViewById(R.id.det);
        list = (LinearLayout) findViewById(R.id.list);
        shareidd = (LinearLayout) findViewById(R.id.shareid);
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                String e = "";
//
                Intent map2 = new Intent(getApplicationContext(),recycleView.class);
               // System.err.println("this is data"+ recycleView.class);
                startActivity(map2);

            }
        });
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
        callview = (LinearLayout) findViewById(R.id.callid);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent map = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(map);
            }
        });
        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gmailint = new Intent(getApplicationContext(),gmailActivity.class);
                startActivity(gmailint);
            }
        });
        callview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callint = new Intent(getApplicationContext(),call.class);
                startActivity(callint);
            }
        });
        shareidd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plan");
                String body = "Your Message:";
                String sub = "";
                intent.putExtra(Intent.EXTRA_SUBJECT,body);
                intent.putExtra(Intent.EXTRA_TEXT,sub);
                startActivity(Intent.createChooser(intent,"Sharing App"));

            }
        });
    }
}
