package com.example.threadingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler h=new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(MainActivity.this,SimpleJavaThread.class);
//                Intent i=new Intent(MainActivity.this,FirstActivity.class);
//                Intent i=new Intent(MainActivity.this,AsyncTL.class);
                startActivity(i);
                finish();
            }
        },2000);
    }
}