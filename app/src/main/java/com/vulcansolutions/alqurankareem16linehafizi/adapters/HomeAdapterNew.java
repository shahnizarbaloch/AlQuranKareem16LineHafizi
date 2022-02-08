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
import com.vulcansolutions.alqurankareem16linehafizi.models.HomeMenu;
import java.util.List;

public class HomeAdapterNew extends RecyclerView.Adapter<HomeAdapterNew.MyViewHolder>{

    private final Context context;
    private final List<HomeMenu> list;
    private final OnMyOwnClickListener onMyOwnClickListener;


    public HomeAdapterNew(Context context, List<HomeMenu> list,
                          OnMyOwnClickListener onMyOwnClickListener) {
        this.context = context;
        this.list = list;
        this.onMyOwnClickListener = onMyOwnClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(context);
        @SuppressLint("InflateParams")
        final View view = inflater.inflate(R.layout.design_home_menu_full_width, null, false);
        return new MyViewHolder(view,onMyOwnClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final HomeMenu obj = list.get(position);
        holder.tv_title.setText(obj.getTitle());
        holder.tv_text.setText(obj.getText());
        Picasso.get().load(obj.getImg()).into(holder.imgIcon);

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
        CardView main_card;
        TextView tv_title, tv_text;
        ImageView imgIcon;

        OnMyOwnClickListener onMyOwnClickListener;

        public MyViewHolder(@NonNull View itemView, OnMyOwnClickListener onMyOwnClickListener) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_text = itemView.findViewById(R.id.tv_text);
            imgIcon = itemView.findViewById(R.id.img);
            main_card = itemView.findViewById(R.id.main_card);

            this.onMyOwnClickListener = onMyOwnClickListener;

            main_card.setOnClickListener(this);
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
