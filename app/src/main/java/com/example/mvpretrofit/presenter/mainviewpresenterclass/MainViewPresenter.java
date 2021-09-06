package com.example.mvpretrofit.presenter.mainviewpresenterclass;

import android.util.Log;

import com.example.mvpretrofit.model.moviemodelclass.MovieModel;
import com.example.mvpretrofit.presenter.contract.MainActivityContract;
import com.example.mvpretrofit.model.entity.TopMovieResponse;

import retrofit2.Response;

public class MainViewPresenter implements MainActivityContract.Presenter,MainActivityContract.APIListener {


    MainActivityContract.View mView;
    MainActivityContract.Model mModel;
public MainViewPresenter(MainActivityContract.View view){
    mView=view;
    mModel=new MovieModel();
    mView.setupUI();
    getTopMovies(mView.getAPIKey());
}

    @Override
    public void getTopMovies(String apiKey) {


    mView.showProgressDialog();
    mModel.getTopMovies(apiKey,this);
    }

    @Override
    public void onSuccess(Response<TopMovieResponse> response) {
        Log.d("mvp", response.body().getResults().size() + "");
        mView.hideProgressDialog();
        mView.displayMovieData(response.body().getResults());
    }

    @Override
    public void onError(Response<TopMovieResponse> response) {
mView.hideProgressDialog();
mView.showMessage("Error Occured");
    }

    @Override
    public void onFailure(Throwable t) {

    mView.hideProgressDialog();
    mView.showMessage(t.getMessage());
    }
}
