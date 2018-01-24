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

public class CourseScrollAdapter extends RecyclerView.Adapter<CourseScrollAdapter.CourseHolder>{
    private ArrayList<String> titleDataSet,subtitleDataSet;
    private int[] imageDataSet;

    public CourseScrollAdapter(ArrayList<String> titleDataSet, ArrayList<String> subtitleDataSet, int[] imageDataSet) {
        this.titleDataSet = titleDataSet;
        this.subtitleDataSet = subtitleDataSet;
        this.imageDataSet = imageDataSet;
    }

    @Override
    public CourseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.course_scroll_layout,parent,false);
        CourseHolder holder=new CourseHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CourseHolder holder, int position) {
        holder.course_title.setText(titleDataSet.get(position));
        holder.course_image.setImageResource(imageDataSet[position]);
        holder.course_subtitle.setText(subtitleDataSet.get(position));
        holder.course_price.setText(" ₹ 10000");
        holder.course_time.setText("10 Hrs");
    }

    @Override
    public int getItemCount() {
        return titleDataSet.size();
    }

    public class CourseHolder extends RecyclerView.ViewHolder{
        public ImageView course_image;
        public TextView course_title,course_subtitle,course_price,course_time;
        public CourseHolder(View itemView) {
            super(itemView);
            course_image=(ImageView)itemView.findViewById(R.id.course_image);
            course_title=(TextView)itemView.findViewById(R.id.course_title);
            course_subtitle=(TextView)itemView.findViewById(R.id.course_subtitle);
            course_price=(TextView)itemView.findViewById(R.id.course_price);
            course_time=(TextView)itemView.findViewById(R.id.course_time);
        }
    }
}
