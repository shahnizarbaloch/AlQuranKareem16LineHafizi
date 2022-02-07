package com.vulcansolutions.alqurankareem16linehafizi.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.squareup.picasso.Picasso;
import com.vulcansolutions.alqurankareem16linehafizi.R;

public class ViewPagerAdapter extends PagerAdapter {
    private Context context;
    private String[] imageUrls;
    LayoutInflater layoutInflater;

    public ViewPagerAdapter(Context context, String[] imageUrls) {
        this.context = context;
        this.imageUrls = imageUrls;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return imageUrls.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemView = layoutInflater.inflate(R.layout.image_view_single_layout, container, false);
        ImageView imageView = itemView.findViewById(R.id.reading_page_photoView);
//        PhotoView imageView = new PhotoView(context);
        try {
            Picasso.get().load(imageUrls[position]).error(R.drawable.logo).into(imageView);
        }catch (Exception ignored){
            Picasso.get().load(R.drawable.logo).error(R.drawable.logo).into(imageView);
        }
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}