package com.aayushi.imdb;


import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.aayushi.imdb.remote.model.Movie;

import java.util.List;

public class MovieViewModel extends ViewModel {
    private MovieRepository repository;

    private LiveData<List<Movie>> popularMovies;
    private MutableLiveData<Boolean> loadingState = new MutableLiveData<>();

    public MovieViewModel(Context context) {
        repository = new MovieRepository(context);
        popularMovies = repository.getPopularMovies();
        loadingState.setValue(false); // Set initial loading state to false
    }

    public LiveData<List<Movie>> getPopularMovies() {
        return popularMovies;
    }

    public LiveData<Boolean> getLoadingState() {
        return loadingState;
    }

    public void setLoadingState(boolean isLoading) {
        loadingState.setValue(isLoading);
    }
}

