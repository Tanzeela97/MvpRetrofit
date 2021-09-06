package com.example.mvpretrofit.model.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpretrofit.R;
import com.example.mvpretrofit.databinding.ActivityMainBinding;
import com.example.mvpretrofit.databinding.ActivityMovieItemBinding;
import com.example.mvpretrofit.model.entity.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder>{

    private List<Movie> movieList;

    public MoviesAdapter(List<Movie> list) {

        movieList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        ActivityMovieItemBinding movieItemBinding = ActivityMovieItemBinding.inflate(layoutInflater, parent, false);

        return new ViewHolder(movieItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Movie movie = movieList.get(position);

        holder.activityMovieItemBinding.movieName.setText(movie.getOriginal_title());
        Picasso.get().load("https://image.tmdb.org/t/p/w500" + movie.getPoster_path()).into(holder.moviePoster);
    }

    @Override
    public int getItemCount() {

        return movieList.size();
    }

    public  static class ViewHolder extends RecyclerView.ViewHolder {
        public ActivityMovieItemBinding activityMovieItemBinding;

        public ViewHolder(ActivityMovieItemBinding activityMovieItemBindingLayout) {
            super(activityMovieItemBindingLayout.getRoot());
            activityMovieItemBindingLayout=activityMovieItemBinding;

            moviePoster = activityMovieItemBindingLayout.moviePoster;
        }


        ImageView moviePoster;
        //TextView movieName;
    }
}
