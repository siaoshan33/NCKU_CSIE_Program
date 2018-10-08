package com.example.user.myapplication_pethospital;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ImageView secondImage = (ImageView) findViewById(R.id.imageView_cheer);
        secondImage.setImageResource(R.drawable.cheer);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent().setClass(WelcomeActivity.this,MainActivity_Pet_Hospital.class));
            }
        },2000);

    }
}
