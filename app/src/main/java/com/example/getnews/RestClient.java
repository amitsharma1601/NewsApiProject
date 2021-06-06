package com.example.getnews;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    private Retrofit retrofit;


    private static RestClient restClient;

    private RestClient(){}

    public static RestClient getInstance(){
        if (restClient != null){
            return restClient;
        }
        return new RestClient();
    }


    public NewsApi getNewsApiService(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(NewsApi.class);
    }

}
