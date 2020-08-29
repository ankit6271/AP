package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class Recyclrview extends RecyclerView.Adapter<Recyclrview.Handler> {
    String []x={};
    String []image={};
    Context co;
    public Recyclrview(Context co, String []x,String []image){
        this.x=x;
        this.image=image;
        this.co=co;
    }

    @NonNull
    @Override
    public Handler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(co).inflate(R.layout.layoutforrecyclerview,parent,false);
        return new Handler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Handler holder, int position) {
        holder.t.setText(x[position]);
        Glide.with(co).load(image[position]).into(holder.i);
    }
    
    @Override
    public int getItemCount() {
        return x.length;
    }
    static class Handler extends RecyclerView.ViewHolder{
        ImageView i;
        TextView t;
        public Handler(@NonNull View itemView){
            super(itemView);
           i=itemView.findViewById(R.id.imageView);
           t=itemView.findViewById(R.id.textView);
        }
    }
}
