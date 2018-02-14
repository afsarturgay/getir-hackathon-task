package com.example.workstation.hackathontask.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by workstation on 03/02/2018.
 */

public class GetirAPI {

    final static String BASE_URL = "https://getir-bitaksi-hackathon.herokuapp.com/";

    public static Retrofit getApi() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder
                .client(httpClient.build())
                .build();
        return retrofit;
    }
}
