package com.novel.crackerrank_prototype.service;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static Retrofit retrofit;
    public static Retrofit retrofitSoal;

    public static String URL_DEWA = "http://103.157.81.54:2358/";
    public static String URL_SOAL = "http://192.168.100.218:8080/";

    public static Retrofit getRetrofit() {
        Interceptor interceptor = chain -> {
            Request newRequest = chain.request().newBuilder().addHeader("dewaganteng"
                    , "dewaganteng").build();
            return chain.proceed(newRequest);
        };

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        if (retrofit == null)
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL_DEWA)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();

        return retrofit;
    }

    public static Retrofit getRetrofitSoal() {

        if (retrofitSoal == null) {
            retrofitSoal = new Retrofit.Builder()
                    .baseUrl(URL_SOAL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofitSoal;
    }
}

