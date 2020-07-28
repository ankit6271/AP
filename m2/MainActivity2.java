package com.example.m2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.zip.Inflater;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String []arr=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getIntent();
        arr= getResources().getStringArray(R.array.Spinner);
        Spinner s=(Spinner)findViewById(R.id.spinner);
        TextView v=(TextView)findViewById(R.id.textView6);
        registerForContextMenu(v);
        if (s != null) {
            s.setOnItemSelectedListener(this);
            Log.d("ffffff","not null");
        }
        ArrayAdapter<String> a=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,arr);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(a);
        Log.i("\"aht\"","after set adapter");
        Button b=(Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder h=new AlertDialog.Builder(MainActivity2.this);
                h.setTitle("chup gandu").setMessage("For gandu dialog");
                h.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"b",Toast.LENGTH_SHORT).show();
                    }
                });
                h.setNegativeButton("by", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                h.show();
            }
        });
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater i=getMenuInflater();
        i.inflate(R.menu.menu_main,menu);
    }
//used get a dialog for like copy cut paste like
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.yes:
                Toast.makeText(this,"yes text wala",Toast.LENGTH_SHORT).show();
                System.out.println("yes text");
                break;
            case R.id.no:
                Toast.makeText(this,"no For text",Toast.LENGTH_SHORT).show();
                System.out.println("no wala");
                break;
            case R.id.bg:
                Toast.makeText(this,"default",Toast.LENGTH_SHORT).show();
                System.out.println("Avn hi");
                break;
        }
        return super.onContextItemSelected(item);
    }
    //for spinner these 2 methods onitemselected and onnothingselectd
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, arr[i],Toast.LENGTH_SHORT).show();
        System.out.println("yes");
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(this,"Nothing Sele" ,Toast.LENGTH_SHORT).show();
    }
    //for check box
    public void mhu(View view){
        DialogFragment a= new BlankFragment();
        a.show(getSupportFragmentManager(),"tu chitiya");
    }
    public void tera(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}