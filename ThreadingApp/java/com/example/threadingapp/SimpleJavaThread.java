package com.example.threadingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SimpleJavaThread extends AppCompatActivity {
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_java_thread);
        Button btn5=(Button)findViewById(R.id.button5);
        final ProgressDialog dialog=new ProgressDialog(this);
        final Handler handler =new Handler(getMainLooper());
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.setTitle("Download");
                dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                dialog.setMax(100);
                dialog.show();
                Thread t=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(i=0;i<100;i=i+2){
                            final int finalI = i;
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    dialog.setProgress(finalI);
                                }
                            });
                        }
                        if(i==100){
                            dialog.cancel();
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(SimpleJavaThread.this,"Downloaded",Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                    }
                });
                t.start();
            }
        });

    }
}