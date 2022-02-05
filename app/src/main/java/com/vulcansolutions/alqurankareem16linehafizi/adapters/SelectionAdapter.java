package com.vulcansolutions.alqurankareem16linehafizi.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.vulcansolutions.alqurankareem16linehafizi.R;
import com.vulcansolutions.alqurankareem16linehafizi.models.Selection;
import java.util.ArrayList;
import java.util.List;

public class SelectionAdapter extends RecyclerView.Adapter<SelectionAdapter.MyViewHolder> implements Filterable {

    private final Context context;
    private final List<Selection> list;
    private final List<Selection> filterList;
    private final OnMyOwnClickListener onMyOwnClickListener;


    public SelectionAdapter(Context context, List<Selection> list,
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
        final Selection obj = list.get(position);
        holder.tv_title.setText(obj.getTitle());
        holder.tv_index_number.setText(obj.getIndex());

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
        TextView tv_title,tv_index_number;
        OnMyOwnClickListener onMyOwnClickListener;

        public MyViewHolder(@NonNull View itemView, OnMyOwnClickListener onMyOwnClickListener) {
            super(itemView);
            card_view = itemView.findViewById(R.id.card_view);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_index_number = itemView.findViewById(R.id.tv_index_number);

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


    @Override
    public Filter getFilter() {
        return filteredList;
    }

    public Filter filteredList = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Selection> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList=filterList;
            } else {
                String filterText = constraint.toString().toLowerCase().trim();
                for (Selection item : filterList) {
                    if (item.getTitle().toLowerCase().contains(filterText)
                            ||item.getIndex().toLowerCase().contains(filterText)) {
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
