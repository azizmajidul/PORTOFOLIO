package com.stmikbanisaleh.smart_md.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.stmikbanisaleh.smart_md.R;
import com.stmikbanisaleh.smart_md.Model.Audit.Store_list;

import java.util.ArrayList;
import java.util.List;

public class Store_listAdapter extends RecyclerView.Adapter<Store_listAdapter.Store_list_viewHolder> {


    private Context context;
    private List<Store_list> list = new ArrayList<>();
    private View.OnClickListener listener;

    public Store_listAdapter(List<Store_list> list){

        this.list = list;

    }

    @NonNull
    @Override
    public Store_list_viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        view.setOnClickListener(listener);
        Store_list_viewHolder holder = new Store_list_viewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Store_list_viewHolder holder, int position) {


        Store_list store_list = list.get(position);
        holder.store_id.setText(store_list.getStore_id());
        holder.store_name.setText(store_list.getStore_name());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class Store_list_viewHolder extends RecyclerView.ViewHolder{

        TextView store_id, store_name;

        public Store_list_viewHolder(@NonNull View itemView) {
            super(itemView);
            store_id = itemView.findViewById(R.id.store_id);
            store_name = itemView.findViewById(R.id.store_name);
        }
    }
}
