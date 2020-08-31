package com.example.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView grid=(GridView)findViewById(R.id.Gridview);
        Toolbar tool=(Toolbar)findViewById(R.id.tool);
        setSupportActionBar(tool);
        final DrawerLayout dl=(DrawerLayout)findViewById(R.id.drawer);
        final ActionBarDrawerToggle abdt=new ActionBarDrawerToggle(this,dl,tool,R.string.Ankit,R.string.app_name);
        dl.addDrawerListener(abdt);
        abdt.syncState();
        final NavigationView nav=(NavigationView)findViewById(R.id.nav);
        if(nav!=null){
            nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Toast.makeText(MainActivity.this,"any item",Toast.LENGTH_SHORT).show();
                    dl.closeDrawer(GravityCompat.START,true);
                    return true;
                }
            });
        }
    }
}