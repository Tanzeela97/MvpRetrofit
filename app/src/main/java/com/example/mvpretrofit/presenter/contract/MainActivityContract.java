package com.example.mvpretrofit.presenter.contract;

import com.example.mvpretrofit.model.entity.Movie;
import com.example.mvpretrofit.model.entity.TopMovieResponse;

import java.util.List;

import retrofit2.Response;

public interface MainActivityContract {
    interface Model {

        void getTopMovies(String apiKey, final APIListener listener);
    }

    interface View {

        void setupUI();
        String getAPIKey();

        void displayMovieData(List<Movie> moviesList);
        void showMessage(String msg);


        void showProgressDialog();
        void hideProgressDialog();
    }

    interface Presenter {

        void getTopMovies(String apiKey);
    }

    interface APIListener {

        void onSuccess(Response<TopMovieResponse> response);
        void onError(Response<TopMovieResponse> response);
        void onFailure(Throwable t);
    }

}
