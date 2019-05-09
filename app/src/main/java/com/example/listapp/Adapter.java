package com.example.listapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.vh> {
    private ArrayList<list> mList;
    static class vh extends RecyclerView.ViewHolder{
        TextView mTitle;
        TextView mAuthor;
        Button mDel;


        vh(@NonNull View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.title);
            mAuthor = itemView.findViewById(R.id.desc);

        }
    }

    Adapter(ArrayList<list> list1){
        mList = list1;
    }

    @NonNull
    @Override
    public vh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list,viewGroup, false);
        return new vh(v);
    }

    @Override
    public void onBindViewHolder(@NonNull vh vh1, int i) {
        list cur = mList.get(i);


        vh1.mTitle.setText(cur.getTitle1());
        vh1.mAuthor.setText(cur.getDesc1());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}