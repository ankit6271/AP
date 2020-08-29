package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String []x={"Aaran", "Aaren", "Aarez", "Aarman", "Aaron", "Aaron-James", "Aarron", "Aaryan", "Abhinav","Ankit"};
            String []image={"https://cdn.pixabay.com/photo/2017/09/27/10/31/robot-2791677__340.jpg",
                    "https://cdn.pixabay.com/photo/2017/09/27/10/31/robot-2791677__340.jpg",
                    "https://cdn.pixabay.com/photo/2017/09/27/10/31/robot-2791677__340.jpg",
                    "https://cdn.pixabay.com/photo/2017/09/27/10/31/robot-2791677__340.jpg",
                    "https://cdn.pixabay.com/photo/2017/09/27/10/31/robot-2791677__340.jpg",
                    "https://cdn.pixabay.com/photo/2017/09/27/10/31/robot-2791677__340.jpg","https://cdn.pixabay.com/photo/2017/09/27/10/31/robot-2791677__340.jpg","https://cdn.pixabay.com/photo/2017/09/27/10/31/robot-2791677__340.jpg",
                    "https://cdn.pixabay.com/photo/2017/09/27/10/31/robot-2791677__340.jpg",
                    "https://cdn.pixabay.com/photo/2017/09/27/10/31/robot-2791677__340.jpg"};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar1=(Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);
        Recyclrview r=new Recyclrview(this,x,image);
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setAdapter(r);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

}