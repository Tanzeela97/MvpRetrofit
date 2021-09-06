package com.example.mvpretrofit.model.entity;


import java.util.List;

public class TopMovieResponse {


    private List<Movie> results;

    private String page;

    private String total_pages;

    private String total_results;



    public List<Movie> getResults() {
        return results;
    }

    public String getPage() {
        return page;
    }

    public String getTotal_pages() {
        return total_pages;
    }

    public String getTotal_results() {
        return total_results;
    }

}


