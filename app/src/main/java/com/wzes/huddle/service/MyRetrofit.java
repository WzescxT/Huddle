package com.wzes.huddle.service;

import com.google.gson.GsonBuilder;
import retrofit2.Retrofit.Builder;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetrofit {
    public static RetrofitService getGsonRetrofit() {
        return new Builder().baseUrl("http://59.110.136.134:88/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(RetrofitService.class);
    }

    public static RetrofitService getNormalRetrofit() {
        return new Builder().baseUrl("http://59.110.136.134:88/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(RetrofitService.class);
    }
}
