package com.example.getnews;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public abstract class MyCallBack<T> implements Callback<T>{

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if(response.isSuccessful()){

            success(response.body());
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {

    }

    public abstract void success(T data);
}


