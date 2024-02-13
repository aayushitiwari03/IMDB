package com.aayushi.imdb;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.aayushi.imdb.remote.api.MovieApi;
import com.aayushi.imdb.remote.api.RetrofitClient;
import com.aayushi.imdb.remote.model.Movie;
import com.aayushi.imdb.remote.model.MovieList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    private static final String API_KEY = "38a73d59546aa378980a88b645f487fc";
    private MovieApi apiService;
    private Context context;

    public MovieRepository(Context context) {
        this.context = context;
        apiService = RetrofitClient.createService(MovieApi.class);
    }

    public LiveData<List<Movie>> getPopularMovies() {
        final MutableLiveData<List<Movie>> data = new MutableLiveData<>();

        apiService.getPopularMovies(API_KEY).enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(Call<MovieList> call, Response<MovieList> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    data.setValue(response.body().getMovies());
                }
            }

            @Override
            public void onFailure(Call<MovieList> call, Throwable t) {
                showToast("Failed to fetch movies. Please try again.");
            }
        });

        return data;
    }

    private void showToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
