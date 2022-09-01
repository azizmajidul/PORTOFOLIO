package com.stmikbanisaleh.smart_md;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.stmikbanisaleh.smart_md.Model_Ok.Login.PreferenceManager;
import com.stmikbanisaleh.smart_md.Model_Ok.Login2.Common.UserPreferense;
import com.stmikbanisaleh.smart_md.Ui.Masuk;

public class splash_screen extends AppCompatActivity {

    PreferenceManager preferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        preferenceManager = new PreferenceManager(this);


        //
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                /*mulai activity ke MainActivity setelah 5 detik*/
                if(preferenceManager.isLogin()){
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();

                }else {
                    startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
                }

//                startActivity(new Intent(getApplicationContext(), Login.class));
//                finish();
            }
            /*durasi 5000ms*/
        },2000);

//        if(preferenceManager.isLogin()){
//            startActivity(new Intent(this, MainActivity.class));
//        }else {
//            startActivity(new Intent(this, Login.class));
//        }




    }

}