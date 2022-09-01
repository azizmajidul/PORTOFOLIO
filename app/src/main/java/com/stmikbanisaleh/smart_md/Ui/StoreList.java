package com.stmikbanisaleh.smart_md.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.Toast;

import com.stmikbanisaleh.smart_md.Adapter.Store_listAdapter;
import com.stmikbanisaleh.smart_md.Model.Audit.Store_list;
import com.stmikbanisaleh.smart_md.Model_Ok.Login.PreferenceManager;
import com.stmikbanisaleh.smart_md.R;
import com.stmikbanisaleh.smart_md.remote_access.API;
import com.stmikbanisaleh.smart_md.Model.Audit.PagingRespon;
import com.stmikbanisaleh.smart_md.remote_access.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StoreList extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Store_list> list = new ArrayList<>();
    private Store_listAdapter store_listAdapter;
    private API api;
    private RecyclerView.LayoutManager layoutManager;
    public static Store_list store_list;
    private PreferenceManager preferenceManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audit_store);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"#fffffff\">" + getString(R.string.schedule_label) + "</font>"));
        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        store_listAdapter = new Store_listAdapter(list);
        recyclerView.setAdapter(store_listAdapter);
        api = RetrofitClient.getInstance().getApi();
        preferenceManager = new PreferenceManager(this);
        LoadData();
    }

    private void LoadData(){
        final ProgressDialog loading = ProgressDialog.show(this,"Get Data","Please Wait..",false,false);
        Call<PagingRespon> getList = api.getlist(preferenceManager.getToken());
        getList.enqueue(new Callback<PagingRespon>() {
            @Override
            public void onResponse(Call<PagingRespon> call, Response<PagingRespon> response) {
                loading.dismiss();
                List<Store_list> lists = response.body().getData();
                Log.d("Get Data Success", "row data :" + (lists.size()));
                store_listAdapter = new Store_listAdapter(lists);
                recyclerView.setAdapter(store_listAdapter);
                store_listAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<PagingRespon> call, Throwable t) {
                Toast.makeText(StoreList.this, "Get Data Fail", Toast.LENGTH_SHORT).show();
                loading.dismiss();
            }
        });
    }
}