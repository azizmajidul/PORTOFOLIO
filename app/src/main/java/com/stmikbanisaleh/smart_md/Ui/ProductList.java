package com.stmikbanisaleh.smart_md.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.stmikbanisaleh.smart_md.Adapter.ProductListAdapter;
import com.stmikbanisaleh.smart_md.Adapter.StoreVisitAdapter;
import com.stmikbanisaleh.smart_md.Model_Ok.Store.PagingResponProduct;
import com.stmikbanisaleh.smart_md.Model_Ok.Store.ProductList_m;
import com.stmikbanisaleh.smart_md.Model_Ok.Visit.ListVisit;
import com.stmikbanisaleh.smart_md.R;
import com.stmikbanisaleh.smart_md.remote_access.API;
import com.stmikbanisaleh.smart_md.remote_access.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductList extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<ProductList_m> list = new ArrayList<>();
    private List<ListVisit> listS = new ArrayList<>();
    String store_id, store_name, kode_toko;
    TextView txtStore_id,txtStoreName, toko;
    private API api;
    private ProductListAdapter productListAdapter;
    private  StoreVisitAdapter storeVisitAdapter;
    private RecyclerView.LayoutManager layoutManager;
    public static ProductList productList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

//        parsing to report activity
         store_id = getIntent().getStringExtra("store_id");
         store_name = getIntent().getStringExtra("store_name");
         txtStore_id = findViewById(R.id.txtStore_id);
         txtStore_id.setText(store_id);
         txtStoreName = findViewById(R.id.txtStoreName);
         txtStoreName.setText(store_name);
//         toko = findViewById(R.id.id_toko);
//        kode_toko = getIntent().getStringExtra("id_toko");
//        toko.setText(store_id);


         recyclerView = findViewById(R.id.recyclerview);
         LinearLayoutManager layoutManager = new LinearLayoutManager(this);
         layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
         recyclerView.setLayoutManager(layoutManager);
         productListAdapter = new ProductListAdapter(list);
        storeVisitAdapter = new StoreVisitAdapter(listS);
         recyclerView.setAdapter(productListAdapter);
         api = RetrofitClient.getInstance().getApi();
         LoadData();
    }

    private void LoadData(){
        Call<PagingResponProduct> getListProduct = api.getProductList();
        getListProduct.enqueue(new Callback<PagingResponProduct>() {
            @Override
            public void onResponse(Call<PagingResponProduct> call, Response<PagingResponProduct> response) {
                List<ProductList_m> list = response.body().getData();
                Log.d("Get Data Success", "row data :" + (list.size()));
                productListAdapter = new ProductListAdapter(list);
                recyclerView.setAdapter(productListAdapter);
                productListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<PagingResponProduct> call, Throwable t) {
                Toast.makeText(ProductList.this, "Failed Get Data", Toast.LENGTH_SHORT).show();

            }
        });

    }
}