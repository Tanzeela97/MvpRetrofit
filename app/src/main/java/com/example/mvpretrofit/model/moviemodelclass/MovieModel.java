package com.example.mvpretrofit.model.moviemodelclass;

import com.example.mvpretrofit.presenter.contract.MainActivityContract;
import com.example.mvpretrofit.model.entity.TopMovieResponse;
import com.example.mvpretrofit.presenter.network.TmApiInterface;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieModel  implements MainActivityContract.Model {



    public void getTopMovies(String apiKey, final MainActivityContract.APIListener listener) {

        try {


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            TmApiInterface service = retrofit.create(TmApiInterface.class);

            HashMap<String, String> options = new HashMap<>();
            options.put("api_key", apiKey);
            options.put("language", "en-US");
            options.put("sort_by", "popularity.desc");
            options.put("include_adult", "false");
            options.put("include_video", "false");
            options.put("page", "1");

            Call<TopMovieResponse> call = service.getTopMovies(options);
            call.enqueue(new Callback<TopMovieResponse>() {

                public void onResponse(Call<TopMovieResponse> call, Response<TopMovieResponse> response) {

                    if (response.isSuccessful()) {

                        listener.onSuccess(response);
                    } else {

                        listener.onError(response);
                    }
                }


                public void onFailure(Call<TopMovieResponse> call, Throwable t) {

                    listener.onFailure(t);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
