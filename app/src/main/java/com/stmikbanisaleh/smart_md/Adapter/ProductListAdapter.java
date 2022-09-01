package com.stmikbanisaleh.smart_md.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.internal.Primitives;
import com.stmikbanisaleh.smart_md.Model_Ok.Store.ProductList_m;
import com.stmikbanisaleh.smart_md.Model_Ok.Visit.ListVisit;
import com.stmikbanisaleh.smart_md.R;
import com.stmikbanisaleh.smart_md.Ui.ProductList;
import com.stmikbanisaleh.smart_md.Ui.Report;

import java.util.ArrayList;
import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductListViewHolder> {

    private Context context;
    private List<ProductList_m> list = new ArrayList<>();
    private List<ListVisit> listVisits = new ArrayList<>();
//    private List<ListVisit> listvisit;
    TextView txtStore_id,txtStoreName;


    private View.OnClickListener listener;
    public ProductListAdapter(List<ProductList_m> list){
        this.list = list;
    }




    @NonNull
    @Override
    public ProductListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list, parent, false);
        view.setOnClickListener(listener);
        ProductListAdapter.ProductListViewHolder holder = new ProductListAdapter.ProductListViewHolder(view);
       return  holder;



    }

    @Override
    public void onBindViewHolder(@NonNull ProductListViewHolder holder, final int position) {



        final  ProductList_m productList_m = list.get(position);
        holder.id_product.setText(productList_m.getProduct_id());
        holder.id_category.setText(productList_m.getCategory_id());
        holder.product.setText(productList_m.getProduct_name());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), Report.class);
                intent.putExtra("product_id", list.get(position).getProduct_id());
                intent.putExtra("product_name", list.get(position).getProduct_name());
                v.getContext().startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  static  class ProductListViewHolder extends RecyclerView.ViewHolder{
        TextView product, id_product, id_category;

        public ProductListViewHolder(@NonNull View itemView) {
            super(itemView);
            id_product = itemView.findViewById(R.id.txtid_product);
            product = itemView.findViewById(R.id.produk_name);
            id_category = itemView.findViewById(R.id.txtid_category);


        }
    }
}
