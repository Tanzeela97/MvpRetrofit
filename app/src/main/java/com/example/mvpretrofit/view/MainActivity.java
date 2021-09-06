package com.example.mvpretrofit.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.mvpretrofit.R;
import com.example.mvpretrofit.databinding.ActivityMainBinding;
import com.example.mvpretrofit.model.adapter.MoviesAdapter;
import com.example.mvpretrofit.presenter.contract.MainActivityContract;
import com.example.mvpretrofit.model.entity.Movie;
import com.example.mvpretrofit.presenter.mainviewpresenterclass.MainViewPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View{

    MainActivityContract.Presenter mPresenter;
    ProgressDialog progressDialog;
    RecyclerView recyclerview;
    List<Movie> movieList;
    MoviesAdapter moviesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);


    mPresenter=new MainViewPresenter(this);

    }

    @Override
    public void setupUI() {
    progressDialog=new ProgressDialog(this);
//databinding

        ActivityMainBinding activityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);


        //  recyclerview=findViewById(R.id.recycler_view);

    movieList=new ArrayList<>();
    moviesAdapter=new MoviesAdapter(movieList);

   activityMainBinding.recyclerView.setLayoutManager(new GridLayoutManager(this,2));
    activityMainBinding.recyclerView.setAdapter(moviesAdapter);
    }

    @Override
    public String getAPIKey() {
        return getString(R.string.api_key);
    }

    @Override
    public void displayMovieData(List<Movie> moviesList) {
Log.d("mvp", movieList.size()+"");
    moviesList.clear();
    moviesList.addAll(moviesList);
    moviesAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressDialog() {
if (progressDialog!=null&& progressDialog.isShowing()){
    progressDialog.setMessage("loading");
}
else {
    progressDialog.setIndeterminate(true);
    progressDialog.setMessage("loading");
    progressDialog.setCancelable(false);

    try {
        progressDialog.show();
    } catch (Exception ex) {
        ex.printStackTrace();
    }

}    }

    @Override
    public void hideProgressDialog() {

        try {
            if (progressDialog!=null&& progressDialog.isShowing()){
                progressDialog.dismiss();
                progressDialog.hide();

            } }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }
}