package com.stmikbanisaleh.smart_md.Ui.History;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.stmikbanisaleh.smart_md.R;
import com.stmikbanisaleh.smart_md.Ui.Report;
import com.stmikbanisaleh.smart_md.remote_access.API;
import com.stmikbanisaleh.smart_md.remote_access.RetrofitClient;
import com.stmikbanisaleh.smart_md.remote_access.ServiClient;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Coba extends AppCompatActivity {
    private EditText etName,etEmail;
    private Button insBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coba);
        etName=(EditText)findViewById(R.id.et_name);
        etEmail=(EditText)findViewById(R.id.et_email);


        insBtn=(Button)findViewById(R.id.btn_insert);
        insBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });
    }

    private void insertData() {
//        Integer nama = etName.getText().length();
//        Integer email = etEmail.getText().leng
        String nama=etName.getText().toString().trim();
        String email=etEmail.getText().toString().trim();
        if (nama.isEmpty()) {
            etName.setError("Enter name");
            etName.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            etEmail.setError("enter email");
            etEmail.requestFocus();
            return;
        }

        Call<ResponseBody> call = RetrofitClient.getInstance().getApi().insertdata(email, nama);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(Coba.this, "Berhasil!", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(Coba.this, "Jaringan Error!", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
