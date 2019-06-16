package com.example.aqifkhattak.googlemap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class detailActivity extends AppCompatActivity {
ImageView imageView;
TextView name,role;
String player_name,player_role;
int image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

    }
}
