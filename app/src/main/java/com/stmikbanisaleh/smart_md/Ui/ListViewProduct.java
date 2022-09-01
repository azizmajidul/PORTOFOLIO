package com.stmikbanisaleh.smart_md.Ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.stmikbanisaleh.smart_md.Adapter.ProductListAdapter;
import com.stmikbanisaleh.smart_md.Model_Ok.Store.PagingResponProduct;
import com.stmikbanisaleh.smart_md.Model_Ok.Store.ProductList_m;
import com.stmikbanisaleh.smart_md.Model_Ok.Visit.ListVisit;
import com.stmikbanisaleh.smart_md.R;
import com.stmikbanisaleh.smart_md.remote_access.API;
import com.stmikbanisaleh.smart_md.remote_access.RetrofitClient;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ListViewProduct extends AppCompatActivity  implements ListView.OnItemClickListener{

    private API api;
    private ListView listView;
//    private List<ProductList_m> list = new ArrayList<>();
    private List<ProductList_m> product;
    String id_toko, store_id, store_name, id_user;
    TextView txtId_toko, txtStore_id,txtStoreName, txtId_user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_product);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"#fffffff\">" + getString(R.string.product_label) + "</font>"));
        store_id = getIntent().getStringExtra("store_id");
        store_name = getIntent().getStringExtra("store_name");
        id_toko = getIntent().getStringExtra("id_toko");
        id_user = getIntent().getStringExtra("id");
        txtId_user = findViewById(R.id.txtId_user);
        txtId_user.setText(id_user);
        txtId_toko = findViewById(R.id.txtId_toko);
        txtId_toko.setText(id_toko);
        txtStore_id = findViewById(R.id.txtStore_id);
        txtStore_id.setText(store_id);
        txtStoreName = findViewById(R.id.txtStoreName);
        txtStoreName.setText(store_name);
        listView =  findViewById(R.id.list_product) ;
        listView.setOnItemClickListener(this);
        LoadData();
    }


    private void LoadData(){
        api = RetrofitClient.getInstance().getApi();
        Call<PagingResponProduct> getListProduct = api.getProductList();
        getListProduct.enqueue(new Callback<PagingResponProduct>() {
            @Override
            public void onResponse(Call<PagingResponProduct> call, Response<PagingResponProduct> response) {
                List<ProductList_m> produk = response.body().getData();
                product = produk;
                showList();
                Log.d("Get Data Success", "row data :" + (product.size()));
            }

            @Override
            public void onFailure(Call<PagingResponProduct> call, Throwable t) {
            }
        });
    }
    private void showList(){
        String[] list = new String[product.size()];

        for (int i = 0; i < product.size(); i++){
            list[i] = product.get(i).getProduct_name();

            ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.listview, list);
            listView.setAdapter(adapter);
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, Report.class);
        ProductList_m productList_m = product.get(position);
        intent.putExtra("id_toko", txtId_toko.getText().toString());
        intent.putExtra("store_id",txtStore_id.getText().toString());
        intent.putExtra("store_name", txtStoreName.getText().toString());
        intent.putExtra("id", txtId_user.getText().toString());
        intent.putExtra("product_id", productList_m.getProduct_id());
        intent.putExtra("product_name", productList_m.getProduct_name());
        intent.putExtra("category_id", productList_m.getCategory_id());
        startActivity(intent);
    }
}