package com.example.threadingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
    Button start;
    Async async;
    Boolean valid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        start =(Button)findViewById(R.id.button);
        start.setOnClickListener(this);
        Button stop =(Button)findViewById(R.id.button2);
        stop.setOnClickListener(this);
        Integer y = 5;
        System.out.println(y);
        int x = 89;
        y = x;
        System.out.println(y);


    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.button:
                async=new Async(this);
                async.execute(0);
                break;
            case R.id.button2:
                async.cancel(true);
                break;
        }

    }
}