package com.example.mvpretrofit.presenter.network;



import com.example.mvpretrofit.model.entity.TopMovieResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface TmApiInterface {

    @GET("/3/discover/movie")
    Call<TopMovieResponse> getTopMovies(@QueryMap Map<String, String> options);
}
