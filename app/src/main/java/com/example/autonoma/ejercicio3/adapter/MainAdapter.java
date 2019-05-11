package com.example.autonoma.ejercicio3.adapter;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainAdapter {

    Retrofit retrofit;

    public Retrofit getRetrofit() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://reqres.in/api/").addConverterFactory(GsonConverterFactory.create()).build();

        return retrofit;
    }
}
