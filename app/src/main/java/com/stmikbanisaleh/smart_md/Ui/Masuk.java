package com.stmikbanisaleh.smart_md.Ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.stmikbanisaleh.smart_md.MainActivity;
import com.stmikbanisaleh.smart_md.Model_Ok.Login2.Common.UserPreferense;
import com.stmikbanisaleh.smart_md.Model_Ok.Login2.Common.Utils;
import com.stmikbanisaleh.smart_md.Model_Ok.Login2.Entity.AuthorizationRespon;
import com.stmikbanisaleh.smart_md.R;
import com.stmikbanisaleh.smart_md.remote_access.ServiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Masuk extends AppCompatActivity {

    private Button btn_login;
    private EditText etEmail;
    private EditText etPassword;
    private TextView texErrorLogin;
    private ProgressBar pb_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audit_store2);


        etEmail = findViewById(R.id.email_text);
        etPassword = findViewById(R.id.textpassword);
        pb_login = findViewById(R.id.pb_login);
        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textEmail = etEmail.getText().toString();
                String textPassword = etPassword.getText().toString();
                 if(textEmail.isEmpty()){
                     etEmail.setError("Email Empty");
                     return;
                 }

                 if(textPassword.isEmpty()){
                     etPassword.setError("Password Empty");
                     return;
                 }

                Utils.hideSoftKey(etEmail);
                do_login(textEmail,textPassword);


            }
        });


    }


    private void do_login(final String email, String password){

        pb_login.setVisibility(View.GONE);
        etEmail.setEnabled(false);
        etPassword.setEnabled(false);
        btn_login.setEnabled(false);
        String authorization = "Basic" + Utils.base64Encode(email, password);

        ServiClient.ServiceClient
                .buildServiceClient()
                .login(authorization)
                .enqueue(new Callback<AuthorizationRespon>() {
                    @Override
                    public void onResponse(Call<AuthorizationRespon> call, Response<AuthorizationRespon> response) {
                        if(response.isSuccessful()){
                            AuthorizationRespon auth = response.body();

                            UserPreferense.setTokenUser(Masuk.this, auth.getToken());
                           UserPreferense.setUserId(Masuk.this, auth.getLogginUser().getId());
                           UserPreferense.hasLogin(Masuk.this);

                           startActivity(new Intent(Masuk.this, MainActivity.class));
                           finish();

                        } else {
                            Toast.makeText(Masuk.this, "Unknown login or wrong password for login", Toast.LENGTH_SHORT).show();
                            Log.d("onResponse", "onResponse: " + response.message());
                            pb_login.setVisibility(View.GONE);
                             etEmail.setEnabled(true);
                             etPassword.setEnabled(true);
                             btn_login.setEnabled(true);
                        }
                    }

                    @Override
                    public void onFailure(Call<AuthorizationRespon> call, Throwable t) {


                        Toast.makeText(Masuk.this, "wrong for login", Toast.LENGTH_SHORT).show();
                        Log.d("onResponse", "onResponse: " + t.getMessage());
                        pb_login.setVisibility(View.GONE);
                        etEmail.setEnabled(true);
                        etPassword.setEnabled(true);
                        btn_login.setEnabled(true);

                    }
                });




    }


}