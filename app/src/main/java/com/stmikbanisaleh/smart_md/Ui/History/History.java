package com.stmikbanisaleh.smart_md.Ui.History;

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.stmikbanisaleh.smart_md.Adapter.HistoryAdapter;
import com.stmikbanisaleh.smart_md.Model_Ok.History.ListHistory;
import com.stmikbanisaleh.smart_md.Model_Ok.History.ResponHistory;
import com.stmikbanisaleh.smart_md.Model_Ok.Login.PreferenceManager;
import com.stmikbanisaleh.smart_md.R;
import com.stmikbanisaleh.smart_md.remote_access.API;
import com.stmikbanisaleh.smart_md.remote_access.RetrofitClient;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
//public class History  extends AppCompatActivity {
//    private PreferenceManager preferenceManager;
//    private RecyclerView recyclerView;
//    private RecyclerView.LayoutManager layoutManager;
//    private HistoryAdapter adapter;
//    public static ListHistory listHistory;
//    private API api;
//    private List<ListHistory> list = new ArrayList<>();
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.history);
//        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"#fffffff\">" + getString(R.string.history_label) + "</font>"));
//        recyclerView = findViewById(R.id.recyclerview);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(layoutManager);
//        adapter = new HistoryAdapter(list);
//        recyclerView.setAdapter(adapter);
//        api = RetrofitClient.getInstance().getApi();
//        preferenceManager = new PreferenceManager(this);
//        LoadData();
//    }
//
//    private void LoadData(){
//        Call<ResponHistory> getHistory = api.getHistory("" + preferenceManager.getEmail(), preferenceManager.getToken());
//        getHistory.enqueue(new Callback<ResponHistory>() {
//            @Override
//            public void onResponse(Call<ResponHistory> call, Response<ResponHistory> response) {
//            List<ListHistory> list =response.body().getData();
//                Log.d("Retrofit Get", "Jumlah Informasi : " + (list.size()));
//                adapter = new HistoryAdapter(list);
//                recyclerView.setAdapter(adapter);
//                adapter.notifyDataSetChanged();
//            }
//            @Override
//            public void onFailure(Call<ResponHistory> call, Throwable t) {
//                Toast.makeText(History.this, "get data failed", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//}
public class History  extends AppCompatActivity {
    private PreferenceManager preferenceManager;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private HistoryAdapter adapter;
    public static ListHistory listHistory;
    private API api;
    private List<ListHistory> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);

        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"#fffffff\">" + getString(R.string.history_label) + "</font>"));

        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new HistoryAdapter(list);
        recyclerView.setAdapter(adapter);
        api = RetrofitClient.getInstance().getApi();
        preferenceManager = new PreferenceManager(this);
        LoadData();

    }

    private void LoadData(){
        Call<ResponHistory> getHistory = api.getHistory("" + preferenceManager.getEmail(), preferenceManager.getToken());
        getHistory.enqueue(new Callback<ResponHistory>() {
            @Override
            public void onResponse(Call<ResponHistory> call, Response<ResponHistory> response) {
                List<ListHistory> list =response.body().getData();
                Log.d("Retrofit Get", "Jumlah Informasi : " + (list.size()));
                adapter = new HistoryAdapter(list);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ResponHistory> call, Throwable t) {
                Toast.makeText(History.this, "get data failed", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
