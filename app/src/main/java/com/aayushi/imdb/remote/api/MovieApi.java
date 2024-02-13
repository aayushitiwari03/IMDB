package com.aayushi.imdb.remote.api;

import com.aayushi.imdb.remote.model.MovieList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApi {

    @GET("movie/popular")
    Call<MovieList> getPopularMovies(@Query("api_key")String apiKey);
}
