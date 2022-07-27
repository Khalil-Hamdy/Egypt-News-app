package com.khalil.newsapp;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.khalil.newsapp.Models.NewsHeadLines;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private Context context;
    private List<NewsHeadLines> headLines;
    private  SelectListener listener;

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater
                .from(context).inflate(R.layout.headline_list_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.text_title.setText(headLines.get(position).getTitle());
        holder.text_source.setText(headLines.get(position).getSource().getName());

        if(headLines.get(position).getUrlToImage()!=null){
            Picasso.get().load(headLines.get(position).getUrlToImage()).into(holder.img_headline);
        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.OnNewsClicked(headLines.get(position));
            }
        });
    }

    public CustomAdapter(Context context, List<NewsHeadLines> headLines ,SelectListener listener) {
        this.context = context;
        this.headLines = headLines;
        this.listener=listener;
    }

    @Override
    public int getItemCount() {
        return headLines.size();
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<NewsHeadLines> getHeadLines() {
        return headLines;
    }

    public void setHeadLines(List<NewsHeadLines> headLines) {
        this.headLines = headLines;
    }
}
