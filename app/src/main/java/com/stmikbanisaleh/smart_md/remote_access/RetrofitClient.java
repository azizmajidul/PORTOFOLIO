package com.stmikbanisaleh.smart_md.remote_access;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    //kelas yang akan digunakan sebagai media penghubung antara user activity dengan remote server


    private static String BASE_URL = "http://192.168.43.181:80/MER_APP/";
//private static String BASE_URL = "https://smartmd.000webhostapp.com/";
    private static RetrofitClient retrofitClient;
    private static Retrofit retrofit;

    public RetrofitClient(){
        if(retrofit == null){
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }


    }

    public static synchronized RetrofitClient getInstance() {
        if(retrofitClient == null){
            retrofitClient = new RetrofitClient();
        }
        return retrofitClient;
    }

    public API getApi(){
        return retrofit.create(API.class);

    }
}
