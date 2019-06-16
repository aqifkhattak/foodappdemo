package com.example.aqifkhattak.googlemap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class lastActivity extends AppCompatActivity {
Animation animation;
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);
        imageView = (ImageView)findViewById(R.id.rotated);
        move();

    }
    public void move()
    {
        animation = AnimationUtils.loadAnimation(this,R.anim.rotating);
        imageView.startAnimation(animation);
    }
}
