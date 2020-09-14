package com.example.threadingapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.Loader;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class AsyncTL extends AppCompatActivity implements View.OnClickListener, LoaderManager.LoaderCallbacks<Integer> {
    Button start;
    Button stop;
    TextView t;

//    public static void main(String[] args) {
//        new AsyncTL().new A();
//    }
    AsyncTL.A abel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_t_l);
        start =(Button)findViewById(R.id.button3);
        start.setOnClickListener(this);
        stop =(Button)findViewById(R.id.button4);
        stop.setOnClickListener(this);
        t=(TextView)findViewById(R.id.textView4);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button3:
                getSupportLoaderManager().initLoader(0,null,this);
                break;
            case R.id.button4:
//                as in this i want to stop the thread but AtaskLoader dont provide a way to stop the task so it is effortless
//                1)stoploading() used to call method onStopLoading() Directly.
//                2)cancelLoading() acc to me dont work.
//                3)abonden dont work also.
                abel.stopLoading();
                break;
        }

    }

    @NonNull
    @Override
    public Loader<Integer> onCreateLoader(int id, @Nullable Bundle args) {
        Log.i("St","crete Loader");
        abel=new AsyncTL.A(this);
        return abel;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Integer> loader, Integer data) {
        Log.i("St","InOnLoadFinish"+data);
        t.setText(String.valueOf(data));

    }

    @Override
    public void onLoaderReset(@NonNull Loader<Integer> loader) {

    }

    public static class A extends AsyncTaskLoader<Integer> {

        Activity context;
        int i;
        TextView text;
        Handler handler;
        public A(@NonNull Activity context) {
            super(context);
            this.context=context;
        }

        @Override
        public boolean isAbandoned() {
            return super.isAbandoned();
        }

        @Override
        protected void onStartLoading() {
            super.onStartLoading();
            i=0;
            Log.i("St","InStartLoading");
            text =(TextView)context.findViewById(R.id.textViewAstl);
            handler =new Handler();
            forceLoad();
        }

        @Nullable
        @Override
        public Integer loadInBackground() {
            Log.i("St","InLoadBackground");
            while(i<10){
                try {
                    Thread.sleep(1000);
                    i++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        text.setText(String.valueOf(i));
                    }
                });
            }
            return i;
        }
        @Override
        protected void onStopLoading() {
            super.onStopLoading();
            Log.i("St","InStopLoading");
            abandon();
        }
    }
}