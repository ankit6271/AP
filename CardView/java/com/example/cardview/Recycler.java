package com.example.cardview;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class Recycler extends RecyclerView.Adapter<Recycler.Handler> {
    String [] title={};
    String [] text={};
    Context context_main;
    String [] uri={};
   public Recycler(String []title, String []text, Context context,String []uri){
       this.title=title;
       this.text=text;
       this.context_main=context;
       this.uri=uri;
    }
    @NonNull
    @Override
    public Handler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View i=LayoutInflater.from(context_main).inflate(R.layout.card_view,parent,false);
        return new Handler(i);
    }

    @Override
    public void onBindViewHolder(@NonNull final Handler holder, int position) {
        holder.t1.setText(title[position]);
        holder.t2.setText(text[position]);
        Glide.with(context_main).load(uri[position]).into(holder.i);
        
        //to change font of textview once we click on it using typeface
        final Typeface t= ResourcesCompat.getFont(context_main,R.font.snowburst_one);
        holder.t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.t1.setTypeface(t);
            }
        });
    }

    @Override
    public int getItemCount() {
        return title.length;
    }
    class Handler extends RecyclerView.ViewHolder {
        ImageView i;
        TextView t1,t2;
        public Handler(@NonNull View itemView) {
            super(itemView);
            i=itemView.findViewById(R.id.imageButton);
            t1=itemView.findViewById(R.id.textView);
            t2=itemView.findViewById(R.id.textView2);
        }
    }
}
