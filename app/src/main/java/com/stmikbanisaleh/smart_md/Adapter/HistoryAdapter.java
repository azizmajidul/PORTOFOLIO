package com.stmikbanisaleh.smart_md.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.stmikbanisaleh.smart_md.Model_Ok.History.ListHistory;
import com.stmikbanisaleh.smart_md.R;

import java.util.ArrayList;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ListHistoryViewHolder> {

    private Context context;
    private List<ListHistory> list  = new ArrayList<>();
    private View.OnClickListener listener;

    public HistoryAdapter(List<ListHistory> list){
        this.list = list;
    }

    @NonNull
    @Override
    public ListHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_history, parent, false);
        view.setOnClickListener(listener);
        HistoryAdapter.ListHistoryViewHolder holder = new HistoryAdapter.ListHistoryViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListHistoryViewHolder holder, int position) {

        final ListHistory listHistory = list.get(position);
        holder.store_id.setText(listHistory.getStore_id());
        holder.store_name.setText(listHistory.getStore_name());
        holder.product_name.setText(listHistory.getProduct_name());
        holder.date.setText(listHistory.getCreated_date());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ListHistoryViewHolder extends  RecyclerView.ViewHolder{
        TextView store_id, store_name, product_name, date;

        public ListHistoryViewHolder(@NonNull View itemView) {
            super(itemView);

            store_id = itemView.findViewById(R.id.store_id);
            store_name = itemView.findViewById(R.id.store_name);
            product_name = itemView.findViewById(R.id.product_name);
            date = itemView.findViewById(R.id.date_visit);
        }
    }
}
