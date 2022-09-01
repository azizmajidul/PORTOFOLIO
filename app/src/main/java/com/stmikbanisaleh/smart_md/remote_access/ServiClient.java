package com.stmikbanisaleh.smart_md.remote_access;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiClient {
    public static class ServiceClient {

        private static Retrofit.Builder builder = new Retrofit.Builder();
        private static OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        public static API buildServiceClient() {
            return builder.baseUrl("http://192.168.43.181/MER_APP/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()
                    .create(API.class);
        }
    }
}
