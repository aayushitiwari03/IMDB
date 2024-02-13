package com.aayushi.imdb.remote.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class MovieList {

    @SerializedName("results")
    private List<Movie> movies;

    public MovieList() {
    }

    public MovieList(List<Movie> movies) {
        this.movies = movies;
    }


    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}

