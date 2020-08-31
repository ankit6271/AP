package com.example.myapplication;

import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PgrAdapter extends FragmentStatePagerAdapter {
    int nooftabs;
    public PgrAdapter(@NonNull FragmentManager fm,int nooftabs) {
        super(fm);
        this.nooftabs=nooftabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:return new Fragment1();
            case 1:return new Fragment2();
            case 2:return new Fragment3();
            default:return null;
        }
    }

    @Override
    public int getCount() {
        return nooftabs;
    }
}
