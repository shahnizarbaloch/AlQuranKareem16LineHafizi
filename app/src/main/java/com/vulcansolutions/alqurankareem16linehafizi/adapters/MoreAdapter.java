package com.vulcansolutions.alqurankareem16linehafizi.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.vulcansolutions.alqurankareem16linehafizi.R;
import com.vulcansolutions.alqurankareem16linehafizi.models.MoreMenu;

import java.util.List;

public class MoreAdapter extends RecyclerView.Adapter<MoreAdapter.MyViewHolder>{

    private final Context context;
    private final List<MoreMenu> list;
    private final OnMyOwnClickListener onMyOwnClickListener;


    public MoreAdapter(Context context, List<MoreMenu> list,
                       OnMyOwnClickListener onMyOwnClickListener) {
        this.context = context;
        this.list = list;
        this.onMyOwnClickListener = onMyOwnClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(context);
        @SuppressLint("InflateParams") final View view = inflater.inflate(R.layout.design_more, null, false);
        return new MyViewHolder(view,onMyOwnClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final MoreMenu obj = list.get(position);
        Picasso.get().load(obj.getImg()).into(holder.img);
        holder.tv_title.setText(obj.getTitle());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView card_view;
        ImageView img;
        TextView tv_title;
        OnMyOwnClickListener onMyOwnClickListener;

        public MyViewHolder(@NonNull View itemView, OnMyOwnClickListener onMyOwnClickListener) {
            super(itemView);
            card_view = itemView.findViewById(R.id.card_view);
            img = itemView.findViewById(R.id.img);
            tv_title = itemView.findViewById(R.id.tv_title);

            this.onMyOwnClickListener = onMyOwnClickListener;
            card_view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onMyOwnClickListener.onMyOwnClick(getAdapterPosition(),view);
        }
    }

    public interface OnMyOwnClickListener{
        void onMyOwnClick(int position,View view);
    }



}
