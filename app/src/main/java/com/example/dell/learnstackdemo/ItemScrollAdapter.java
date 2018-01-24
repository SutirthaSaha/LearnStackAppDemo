package com.example.dell.learnstackdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DELL on 24-Jan-18.
 */

public class ItemScrollAdapter extends RecyclerView.Adapter<ItemScrollAdapter.ItemHolder> {
    private ArrayList<String> titleDataSet;
    private ArrayList<String> subtitleDataSet;
    private int[] imageDataSet;

    public ItemScrollAdapter(ArrayList<String> titleDataSet, ArrayList<String> subtitleDataSet, int[] imageDataSet) {
        this.titleDataSet = titleDataSet;
        this.subtitleDataSet = subtitleDataSet;
        this.imageDataSet = imageDataSet;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.home_page_items,parent,false);
        ItemHolder holder=new ItemHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        holder.item_title.setText(titleDataSet.get(position));
        holder.item_image.setImageResource(imageDataSet[position]);
        holder.item_subtitle.setText(subtitleDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return titleDataSet.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder{
        public TextView item_title,item_subtitle;
        public ImageView item_image;
        public ItemHolder(View itemView) {
            super(itemView);
            item_title=(TextView)itemView.findViewById(R.id.item_title);
            item_subtitle=(TextView)itemView.findViewById(R.id.item_subtitle);
            item_image=(ImageView)itemView.findViewById(R.id.item_image);
        }
    }
}
