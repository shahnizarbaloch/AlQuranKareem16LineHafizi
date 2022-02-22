package com.vs.alqurankareem16linehafizi.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vs.alqurankareem16linehafizi.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL= BuildConfig.BASE_URL;

    private static RetrofitClient retrofitClient;
    private final Retrofit retrofit;


    private RetrofitClient(){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static synchronized RetrofitClient getInstance(){
        if(retrofitClient==null){
            retrofitClient = new RetrofitClient();
        }
        return retrofitClient;
    }

    public RetrofitInterface getApi(){
        return retrofit.create(RetrofitInterface.class);
    }

}
