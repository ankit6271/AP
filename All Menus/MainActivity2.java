package com.example.menus;

import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.PopupMenu;
import  android.widget.PopupMenu;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity2 extends AppCompatActivity implements ActionMode.Callback {
    private static TextView t;
    private Button b;
    ActionMode mAction;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);
        Intent i=getIntent();
        MainActivity2.t=(TextView)findViewById(R.id.textView);
        t.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(mAction!=null){
                    return false;
                }
                MainActivity2.this.startActionMode(MainActivity2.this);
                return true;
            }
        });
        b=(Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               PopupMenu p=new PopupMenu(MainActivity2.this,b);
                p.getMenuInflater().inflate(R.menu.menu_for_act2,p.getMenu());
                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(MainActivity2.this,"popupmenu select",Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                p.show();
            }
        });
    }

    @Override
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        actionMode.setTitle(R.string.app_name);
        actionMode.setSubtitle(R.string.yesu);
        getMenuInflater().inflate(R.menu.menu_for_act2,menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        switch(menuItem.getItemId()){
            case R.id.yes:
                Toast.makeText(this,"Yes",Toast.LENGTH_SHORT).show();
                actionMode.finish();
                return true;
            case R.id.no:
                Toast.makeText(this,"No",Toast.LENGTH_SHORT).show();
                actionMode.finish();
                return true;
            case R.id.search:
                Toast.makeText(this,"Search",Toast.LENGTH_SHORT).show();
                actionMode.finish();
                return true;
            case R.id.go:
                Toast.makeText(this,"go",Toast.LENGTH_SHORT).show();
                actionMode.finish();
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onDestroyActionMode(ActionMode actionMode) {
        mAction=null;
    }
}
