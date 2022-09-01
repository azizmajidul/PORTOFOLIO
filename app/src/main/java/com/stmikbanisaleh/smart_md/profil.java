package com.stmikbanisaleh.smart_md;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.stmikbanisaleh.smart_md.Model_Ok.Login.PreferenceManager;
import com.stmikbanisaleh.smart_md.Model_Ok.Login.ResponLogin;
import com.stmikbanisaleh.smart_md.Model_Ok.Login2.Common.UserPreferense;
import com.stmikbanisaleh.smart_md.Model_Ok.Login2.Entity.User;
import com.stmikbanisaleh.smart_md.Model_Ok.Login2.Entity.UserRespon;
import com.stmikbanisaleh.smart_md.Model_Ok.User.ResponUser;
import com.stmikbanisaleh.smart_md.Model_Ok.User.UserList;
import com.stmikbanisaleh.smart_md.Model_Ok.Visit.ListVisit;
import com.stmikbanisaleh.smart_md.Ui.History.History;
import com.stmikbanisaleh.smart_md.remote_access.API;
import com.stmikbanisaleh.smart_md.remote_access.RetrofitClient;
import com.stmikbanisaleh.smart_md.remote_access.ServiClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.stmikbanisaleh.smart_md.Model_Ok.Login.PreferenceManager.USER_NAME;

public class profil extends AppCompatActivity {

    private profil Context;
    private API api;

    private Button logout;
    private ResponLogin login;
    private PreferenceManager preferenceManager;
    private User userdata;
    private RetrofitClient retrofitClient;
    private  UserPreferense userPreferense;

    private ServiClient.ServiceClient serviceClient;

//    public List<UserList> list ;
//    public static UserList userList;

    private TextView
            profilName,
            profilEmail,
            profilAddress,
            profilRole;

    private String name;
    private String email;
    private String address;
    private String role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        preferenceManager = new PreferenceManager(this);



        logout = findViewById(R.id.logout);
        profilName = findViewById(R.id.profil_name);
        profilName.setText(preferenceManager.getEmail());
//
        api = RetrofitClient.getInstance().getApi();
        loadUser();





    }

    private void loadUser(){
        Call<UserRespon> user = api.getDataUser("" + preferenceManager.getEmail());
        user.enqueue(new Callback<UserRespon>() {
            @Override
            public void onResponse(Call<UserRespon> call, Response<UserRespon> response) {
             User user  = response.body().getData();






//                name = user.getName();
//                Log.d("berhasil", "berhasil : " + name);
//                role = user.getRole();
//                email = user.getEmail();
//                profilName.setText(user.getName());
//                profilEmail.setText(email);
//                profilAddress.setText(address);
//                profilRole.setText(role);


            }

            @Override
            public void onFailure(Call<UserRespon> call, Throwable t) {

            }
        });

    }




//    private void loadUser(){
//
//
//        Call<ResponUser> user = api.getDataUser("" + preferenceManager.getEmail());
//              user.enqueue(new Callback<ResponUser>() {
//                  @Override
//                  public void onResponse(Call<ResponUser> call, Response<ResponUser> response) {
////                      UserList = response.body().getData();
//                      List<UserList> userList = response.body().getData();
//
//
//
//
//
//
//                      name = userList.getName();
////                      email = userList.getEmail();
////                      address = userList.getAddress();
////                      role = userList.getRole();
////
////                      profilName.setText(name);
////                      profilEmail.setText(email);
////                      profilAddress.setText(address);
////                      profilRole.setText(role);
//                      Toast.makeText(profil.this, "get data success", Toast.LENGTH_SHORT).show();
//                  }
//
//                  @Override
//                  public void onFailure(Call<ResponUser> call, Throwable t) {
//                      Toast.makeText(profil.this, "get data fail", Toast.LENGTH_SHORT).show();
//
//                  }
//              });
//
//
//
//
//
//
//
//    }

//    public void getUser(){
//
//        api = RetrofitClient.getInstance().getApi();
//
//        Call<ResponUser> getListUser = api.getDataUser();
//        getListUser.enqueue(new Callback<ResponUser>() {
//            @Override
//            public void onResponse(Call<ResponUser> call, Response<ResponUser> response) {
//              List<UserList> listss = response.body().getData();
////                listss = list;
//
//            }
//
//            @Override
//            public void onFailure(Call<ResponUser> call, Throwable t) {
//                Toast.makeText(profil.this, "Gagal ambil data", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//
//    }
}