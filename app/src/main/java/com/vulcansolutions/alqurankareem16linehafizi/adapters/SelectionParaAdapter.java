package com.vulcansolutions.alqurankareem16linehafizi.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.vulcansolutions.alqurankareem16linehafizi.R;
import com.vulcansolutions.alqurankareem16linehafizi.room_model.ParaRoom;
import com.vulcansolutions.alqurankareem16linehafizi.room_model.SurahRoom;

import java.util.ArrayList;
import java.util.List;

public class SelectionParaAdapter extends RecyclerView.Adapter<SelectionParaAdapter.MyViewHolder> implements Filterable {

    private final Context context;
    private final List<ParaRoom> list;
    private final List<ParaRoom> filterList;
    private final OnMyOwnClickListener onMyOwnClickListener;


    public SelectionParaAdapter(Context context, List<ParaRoom> list,
                                OnMyOwnClickListener onMyOwnClickListener) {
        this.context = context;
        this.list = list;
        this.onMyOwnClickListener = onMyOwnClickListener;
        filterList = new ArrayList<>(list);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(context);
        @SuppressLint("InflateParams") final View view = inflater.inflate(R.layout.design_aayat_list, null, false);
        return new MyViewHolder(view,onMyOwnClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final ParaRoom obj = list.get(position);
        holder.tv_title.setText(obj.getArabicTitle());
        holder.tv_index_number.setText(obj.getIndexNumber());
        holder.tv_title_english.setText(obj.getEnglishTitle());

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
        TextView tv_title,tv_title_english,tv_index_number;
        ImageView img_like;
        OnMyOwnClickListener onMyOwnClickListener;

        public MyViewHolder(@NonNull View itemView, OnMyOwnClickListener onMyOwnClickListener) {
            super(itemView);
            card_view = itemView.findViewById(R.id.card_view);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_title_english= itemView.findViewById(R.id.tv_title_english);
            tv_index_number = itemView.findViewById(R.id.tv_index_number);
            img_like = itemView.findViewById(R.id.img_like);

            this.onMyOwnClickListener = onMyOwnClickListener;
            card_view.setOnClickListener(this);
            img_like.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onMyOwnClickListener.onMyOwnClick(getAdapterPosition(),view);
        }
    }

    public interface OnMyOwnClickListener{
        void onMyOwnClick(int position,View view);
    }


    @Override
    public Filter getFilter() {
        return filteredList;
    }

    public Filter filteredList = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ParaRoom> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList=filterList;
            } else {
                String filterText = constraint.toString().toLowerCase().trim();
                for (ParaRoom item : filterList) {
                    if (item.getArabicTitle().toLowerCase().contains(filterText)
                            ||item.getIndexNumber().toLowerCase().contains(filterText)) {
                        filteredList.add(item);
                    }
                }

            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @SuppressLint("NotifyDataSetChanged")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            list.clear();
            list.addAll((ArrayList)results.values);
            notifyDataSetChanged();

        }
    };

}
