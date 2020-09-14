package com.example.threadingapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Async extends AsyncTask<Integer,Integer,Integer>{
    @SuppressLint("StaticFieldLeak")
    Activity context;
    @SuppressLint("StaticFieldLeak")
    TextView textView;
    Boolean valid;
   int i=5;
    public Async(Activity context) {
        super();
        this.context=context;
        Log.i("String","onAsync");
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        textView=(TextView) context.findViewById(R.id.textView3);
        Log.i("String","onPre");
    }

    @Override
    protected Integer doInBackground(Integer... intel) {
        Log.i("String","onDo");
        intel[0]=i;
        Log.i("String", String.valueOf(intel[0].getClass()));
        while (!isCancelled()){
            try {
                Thread.sleep(1000);
                i=i+1;
                publishProgress(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return i;
    }
    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        textView.setText(""+integer);
        Log.i("String","onpost");
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        Log.i("String","onprogress");
        textView.setText(String.valueOf(values[0]));
    }

    @Override
    protected void onCancelled(Integer integer) {
        super.onCancelled(integer);
        Log.i("String","oncan");
    }
}
