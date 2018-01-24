package com.example.dell.learnstackdemo;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by DELL on 24-Jan-18.
 */

public class ImageSliderAdapter extends PagerAdapter {
    Activity activity;
    int[] images;
    LayoutInflater layoutInflater;

    public ImageSliderAdapter(Activity activity, int[] images) {
        this.activity = activity;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater=(LayoutInflater)activity.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=layoutInflater.inflate(R.layout.course_image_slider_item,container,false);

        ImageView imageview;
        imageview=(ImageView)itemView.findViewById(R.id.course_slider_view);
        imageview.setImageResource(images[position]);

        ViewPager viewPager= (ViewPager) container;
        viewPager.addView(itemView);
        return itemView;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager viewPager=(ViewPager)container;
        View view=(View)object;
        viewPager.removeView(view);
    }
}
