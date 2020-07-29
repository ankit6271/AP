package com.example.m3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar x=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(x);
        TabLayout t=findViewById(R.id.tab_layout);
        ViewPager p= (ViewPager) findViewById(R.id.pager);
        PagerAdapter pi=new PagerAdapter(getSupportFragmentManager(),t.getTabCount());
        p.setAdapter(pi);
    }
}