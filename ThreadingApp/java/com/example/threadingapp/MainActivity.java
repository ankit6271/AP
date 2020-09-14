// This activity is for splash screen In a Project.

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
                
                //Choose any of the below activity to implement as an intent just do remove a comment portion only.
               
                //1-----------This Intent is for a activity which is basically for Normal java thread which provides a progress dialog
                Intent i=new Intent(MainActivity.this,SimpleJavaThread.class);
                
                //2------------This Intent is for a activity which is basically for AsyncTask thread which provides a counting mechanism
               Intent i=new Intent(MainActivity.this,FirstActivity.class);
                
                //3------------This Intent is for a activity which is basically for AsyncTaskLoader thread which provides a counting mechanism
               Intent i=new Intent(MainActivity.this,AsyncTL.class);
                startActivity(i);
                finish();
            }
        },2000);
    }
}
