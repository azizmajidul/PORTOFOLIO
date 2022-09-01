package com.stmikbanisaleh.smart_md;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.stmikbanisaleh.smart_md.Model_Ok.Login.LoginReaquest;
import com.stmikbanisaleh.smart_md.Model_Ok.Login.PreferenceManager;
import com.stmikbanisaleh.smart_md.Model_Ok.Login.ResponLogin;
import com.stmikbanisaleh.smart_md.Model_Ok.Login2.Entity.User;
import com.stmikbanisaleh.smart_md.Model_Ok.Login2.Entity.UserRespon;
import com.stmikbanisaleh.smart_md.remote_access.API;
import com.stmikbanisaleh.smart_md.remote_access.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    private String TAG = "Login";
    private Button btn_login;
    private EditText email;
    private EditText password;
    private TextView texErrorLogin;
    private ProgressBar pb_login;
    private CheckBox checkBox;
    private PreferenceManager preferenceManager;
    private RetrofitClient  retrofitClient;
    private LoginReaquest loginReaquest;
    UserRespon userRespon;
    private User usre;
//    private ResponLogin responLogin;
    private boolean statusPassword = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn_login = (Button) findViewById(R.id.btn_login);
        email = findViewById(R.id.email_text);
        password = findViewById(R.id.textpassword);
        texErrorLogin = findViewById(R.id.texErrorLogin);
        pb_login = findViewById(R.id.pb_login);
        checkBox = findViewById(R.id.checkBox);
        loginReaquest= new LoginReaquest();
        preferenceManager = new PreferenceManager(this);
        retrofitClient =RetrofitClient.getInstance();
        setUser();
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login_action();
            }
        });
    }
    private boolean isDataValid(){
        String error = "";
        boolean r =false;
        if(email.getText().toString().length() < 1){
            error = "Email Cannot Be Null";
            Toast.makeText(this,error, Toast.LENGTH_SHORT).show();
            texErrorLogin.setText(error);

        }else if(password.getText().toString().length() < 1){
            error = " Password Can't Be Null";
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
            r = false;
        }else {
            r = true;
        }
        return r;
    }

    private void remember_me(){
    if(checkBox.isChecked()){
            preferenceManager.setEmail(email.getText().toString());
            preferenceManager.setPassword(password.getText().toString());
            preferenceManager.setRememberMe(true);
        }else{
            preferenceManager.setEmail(email.getText().toString());
            preferenceManager.setPassword("");
            preferenceManager.setRememberMe(false);
        }
    }
    private void setUser(){
        if(preferenceManager.Remember_me()){
            loginReaquest.setEmail(preferenceManager.getEmail());
            loginReaquest.setPassword(preferenceManager.getPassword());
            email.setText(preferenceManager.getEmail());
            password.setText(preferenceManager.getPassword());
            checkBox.setChecked(true);
        } else {
            checkBox.setChecked(false);
            email.setText(preferenceManager.getEmail());
            password.setText(preferenceManager.getPassword());
        }
    }
    private  void saveRespon(ResponLogin responLogin){
        preferenceManager.setToken(responLogin.getToken());
        preferenceManager.setLogin(true);
    }

    public void login_action(){
        texErrorLogin.setText(" ");
        if (isDataValid()){

            pb_login.setVisibility(View.VISIBLE);
            remember_me();
            API api =retrofitClient.getApi();

            loginReaquest.setEmail(email.getText().toString());
            loginReaquest.setPassword(password.getText().toString());
            Call<ResponLogin> coba = api.auth(loginReaquest);
            coba.enqueue(new Callback<ResponLogin>() {
                @Override
                public void onResponse(Call<ResponLogin> call, Response<ResponLogin> response) {
                    Log.d(TAG, "success respon");
                    if(response.isSuccessful()){
                        if(response.body().isStatus()){
                            Log.d("++++", response.body().getToken().toString());
                            saveRespon(response.body());
                            getProfil(response.body().getToken(), response.body());
                        } else {
                            pb_login.setVisibility(View.GONE);
                            texErrorLogin.setText(response.body().getMessage());
                            Toast.makeText(Login.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        pb_login.setVisibility(View.GONE);
                        texErrorLogin.setText("eroooooooor");
                        Toast.makeText(Login.this, "eroooooooor", Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
                public void onFailure(Call<ResponLogin> call, Throwable t) {

                    t.printStackTrace();
                    pb_login.setVisibility(View.GONE);

                    Toast.makeText(Login.this, "Please check your connection or internet access", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }



    private  void getProfil(String token, ResponLogin body){
        pb_login.setVisibility(View.GONE);
        preferenceManager.setToken(token);
        Intent intent = new Intent(Login.this, MainActivity.class);
        startActivity(intent);
        finish();

    }


}