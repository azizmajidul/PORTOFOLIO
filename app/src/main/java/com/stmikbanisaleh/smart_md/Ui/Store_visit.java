package com.stmikbanisaleh.smart_md.Ui;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import com.stmikbanisaleh.smart_md.Adapter.StoreVisitAdapter;
import com.stmikbanisaleh.smart_md.Model.Audit.PagingRespon;
import com.stmikbanisaleh.smart_md.Model.Audit.Store_list;
import com.stmikbanisaleh.smart_md.Model_Ok.Login.PreferenceManager;
import com.stmikbanisaleh.smart_md.Model_Ok.Visit.ListVisit;
import com.stmikbanisaleh.smart_md.Model_Ok.Visit.PagingResponStore_v;
import com.stmikbanisaleh.smart_md.R;
import com.stmikbanisaleh.smart_md.remote_access.API;
import com.stmikbanisaleh.smart_md.remote_access.RetrofitClient;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Store_visit extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<ListVisit> list = new ArrayList<>();
    private StoreVisitAdapter storeVisitAdapter;
    private API api;
    private RecyclerView.LayoutManager layoutManager;
    public static ListVisit listVisit;
    private PreferenceManager preferenceManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_visit);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"#fffffff\">" + getString(R.string.store_label) + "</font>"));
        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        storeVisitAdapter = new StoreVisitAdapter(list);
        recyclerView.setAdapter(storeVisitAdapter);
        api = RetrofitClient.getInstance().getApi();
        preferenceManager = new PreferenceManager(this);
        LoadData();
    }

    private void LoadData(){
        final ProgressDialog loading = ProgressDialog.show(this,"Get Data","Please Wait..",false,false);
        Call<PagingResponStore_v> getList = api.getListStore_visit("" + preferenceManager.getEmail(), preferenceManager.getToken());
        getList.enqueue(new Callback<PagingResponStore_v>() {
            @Override
            public void onResponse(Call<PagingResponStore_v> call, Response<PagingResponStore_v> response) {
                loading.dismiss();
                List<ListVisit> lists = response.body().getData();
                Log.d("Get Data Success", "row data :" + (lists.size()));
                storeVisitAdapter = new StoreVisitAdapter(lists);
                recyclerView.setAdapter(storeVisitAdapter);
                storeVisitAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<PagingResponStore_v> call, Throwable t) {

                Toast.makeText(Store_visit.this, "Failed Get Data", Toast.LENGTH_SHORT).show();
                loading.dismiss();
            }
        });

    }
}