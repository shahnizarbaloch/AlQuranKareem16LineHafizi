package com.vs.alqurankareem16linehafizi.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import com.vs.alqurankareem16linehafizi.R;
import com.vs.alqurankareem16linehafizi.models.Ayat;
import java.util.ArrayList;
import java.util.List;

public class ParaViewAdapter extends RecyclerView.Adapter<ParaViewAdapter.MyViewHolder>{

    private final Context context;
    private final List<Ayat> list;
    private final OnMyOwnClickListener onMyOwnClickListener;


    public ParaViewAdapter(Context context, List<Ayat> list,
                           OnMyOwnClickListener onMyOwnClickListener) {
        this.context = context;
        this.list = list;
        this.onMyOwnClickListener = onMyOwnClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(context);
        @SuppressLint("InflateParams") final View view = inflater.inflate(R.layout.design_ayat, null, false);
        return new MyViewHolder(view,onMyOwnClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Ayat obj = list.get(position);
        if (obj.getBaseNumber().equalsIgnoreCase("1")){
            Picasso.get().load(R.drawable.test_one).into(holder.reading_page_photoView);
        }
        else{
            Picasso.get().load(R.drawable.test_two).into(holder.reading_page_photoView);
        }

        if(obj.isSelected()){
            holder.card_view.setCardBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
        }
        else{
            holder.card_view.setCardBackgroundColor(context.getResources().getColor(R.color.white));
        }


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
        ImageView reading_page_photoView;
        OnMyOwnClickListener onMyOwnClickListener;

        public MyViewHolder(@NonNull View itemView, OnMyOwnClickListener onMyOwnClickListener) {
            super(itemView);
            card_view = itemView.findViewById(R.id.card_view);
            reading_page_photoView = itemView.findViewById(R.id.reading_page_photoView);

            this.onMyOwnClickListener = onMyOwnClickListener;

            card_view.setOnClickListener(this);
            itemView.setOnClickListener(this);
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
