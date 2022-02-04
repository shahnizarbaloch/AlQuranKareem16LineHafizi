package com.vulcansolutions.alqurankareem16linehafizi.adapters;

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

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private final List<HomeMenu> arrayList;
    private final Context context;
    private final OnMyOwnClickListener onMyOwnClickListener;

    //These variables are for designing the layout of categories
    public static final int TYPE_LARGE=0;
    public static final int TYPE_NORMAL=1;


    public HomeAdapter(List<HomeMenu> arrayList, Context context, OnMyOwnClickListener onMyOwnClickListener){
        this.arrayList=arrayList;
        this.context=context;
        this.onMyOwnClickListener=onMyOwnClickListener;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view;
        RecyclerView.ViewHolder viewHolder;
        if (viewType == TYPE_NORMAL) {
            view = inflater.inflate(R.layout.design_home_menu, parent, false);
            viewHolder = new TwoOptionHolder(view, onMyOwnClickListener);
        }
        else{
            view = inflater.inflate(R.layout.design_home_menu_full_width, parent, false);
            viewHolder = new SingleOptionHolder(view, onMyOwnClickListener);
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        final HomeMenu obj = arrayList.get(position);
        switch (holder.getItemViewType()) {
            case TYPE_NORMAL:
                TwoOptionHolder twoOptionHolder = (TwoOptionHolder)holder;
                twoOptionHolder.tv_title.setText(obj.getTitle());
                twoOptionHolder.tv_text.setText(obj.getText());
                Picasso.get().load(obj.getImg()).into(twoOptionHolder.imgIcon);
                if (obj.getTitle().equalsIgnoreCase(context.getString(R.string.home_menu_bookmark))){
                    twoOptionHolder.main_card.setCardBackgroundColor(context.getResources().getColor(R.color.card_color1));
                }
                else if (obj.getTitle().equalsIgnoreCase(context.getString(R.string.home_menu_share))){
                    twoOptionHolder.main_card.setCardBackgroundColor(context.getResources().getColor(R.color.card_color2));
                }
                break;

            case TYPE_LARGE:
                SingleOptionHolder singleOptionHolder = (SingleOptionHolder)holder;
                singleOptionHolder.tv_title.setText(obj.getTitle());
                singleOptionHolder.tv_description.setText(obj.getText());
                Picasso.get().load(obj.getImg()).into(singleOptionHolder.imgIcon);

                if (obj.getTitle().equalsIgnoreCase(context.getString(R.string.home_menu_quran))){
                    singleOptionHolder.main_card.setCardBackgroundColor(context.getResources().getColor(R.color.card_color5));
                }
                else if(obj.getTitle().equalsIgnoreCase(context.getString(R.string.home_menu_continue_reciting))){
                    singleOptionHolder.main_card.setCardBackgroundColor(context.getResources().getColor(R.color.card_color3));
                }

                break;
        }

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    static class TwoOptionHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView main_card;
        TextView tv_title, tv_text;
        ImageView imgIcon;

        OnMyOwnClickListener onMyOwnClickListener;
        TwoOptionHolder(@NonNull View itemView, OnMyOwnClickListener onMyOwnClickListener) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_text = itemView.findViewById(R.id.tv_text);
            imgIcon = itemView.findViewById(R.id.img);
            main_card = itemView.findViewById(R.id.main_card);

            this.onMyOwnClickListener = onMyOwnClickListener;

            main_card.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onMyOwnClickListener.onMyOwnClick(getAdapterPosition(),v);
        }
    }

    static class SingleOptionHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView main_card;
        TextView tv_title,tv_description;
        ImageView imgIcon;

        OnMyOwnClickListener onMyOwnClickListener;
        SingleOptionHolder(@NonNull View itemView, OnMyOwnClickListener onMyOwnClickListener) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_description = itemView.findViewById(R.id.tv_text);
            imgIcon = itemView.findViewById(R.id.img);
            main_card = itemView.findViewById(R.id.main_card);

            this.onMyOwnClickListener = onMyOwnClickListener;

            main_card.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onMyOwnClickListener.onMyOwnClick(getAdapterPosition(),v);
        }
    }

    public interface OnMyOwnClickListener{
        void onMyOwnClick(int position,View view);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public int getItemViewType(int position) {
        final HomeMenu obj = arrayList.get(position);
        if(obj.getTitle().equalsIgnoreCase(context.getString(R.string.home_menu_quran))||
                obj.getTitle().equalsIgnoreCase(context.getString(R.string.home_menu_continue_reciting))){
            return TYPE_LARGE;
        }
        else{
            return TYPE_NORMAL;
        }
    }
}
