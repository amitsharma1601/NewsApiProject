package com.example.getnews;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {
    // as we are making get request so we are displaying
    // GET as annotation.
    // and inside we are passing last parameter for our url.

    // as we are calling data from array so we are calling
    // it with array list and naming that method as getAllCourses();
    @GET("/v2/top-headlines")

    // ?q=Apple&from=2021-05-08&apiKey=eb131b16f3804d84b3dbf4073d938458&country="India"
    Call<RecyclerModel> fetchHeadlines(@Query("apiKey") String apiKey,
                                  @Query("from") String from,
                                  @Query("q") String q,
                                  @Query("country") String country);

    @GET("NewsAPI/everything/cnn.json")
    Call<RecyclerModel> fetchEverything(
                                       @Query("NewsAPI") String NewsAPI,
                                       @Query("everything") String everything);

    @GET("NewsAPI/top-headlines/category/health/in.json")
    Call<RecyclerModel> fetchEverythingBBC(
            @Query("NewsAPI") String NewsAPI,
            @Query("everything") String everything);

    @GET("NewsAPI/top-headlines/category/sports/in.json")
    Call<RecyclerModel> fetchsports(
            @Query("NewsAPI") String NewsAPI,
            @Query("everything") String everything);

    @GET("NewsAPI/top-headlines/category/business/in.json")
    Call<RecyclerModel> fetchbusiness(
            @Query("NewsAPI") String NewsAPI,
            @Query("everything") String everything);

    @GET("NewsAPI/top-headlines/category/entertainment/in.json")
    Call<RecyclerModel> fetchentertainment(
            @Query("NewsAPI") String NewsAPI,
            @Query("everything") String everything);

}
