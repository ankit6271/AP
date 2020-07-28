package com.example.m2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListView l=(ListView) findViewById(R.id.lv);
        String arr[]={"ram","Sham","Tera","baap" ,"kjjh","llo","kjhuu","opiuytgggg","khfgdggd","kjhuu","opiuytgggg","khfgdggd","kjhuu","opiuytgggg","khfgdggd"};
        ArrayAdapter a=new ArrayAdapter(this,android.R.layout.simple_selectable_list_item,arr);
        l.setAdapter(a);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void my(View view){
        Intent i=new Intent(this,MainActivity2.class);
        startActivity(i);
    }
    //For menu selection
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.yes:
                Toast.makeText(this,"yest",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.no:
                Toast.makeText(this,"no",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.haan:
                Toast.makeText(this,"haan",Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    //when back key pressed
    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert=new AlertDialog.Builder(this).setMessage("tu loda gandu");
        alert.setTitle("Are u sure").setMessage("Are u sure");
        alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alert.setNegativeButton("Cnacel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "Lets", Toast.LENGTH_SHORT).show();
            }
        });
        alert.setCancelable(false).show();
    }
}