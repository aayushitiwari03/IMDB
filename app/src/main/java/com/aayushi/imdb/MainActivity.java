package com.aayushi.imdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private MovieViewModel movieViewModel;
    private MovieAdapter movieAdapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieViewModel = new ViewModelProvider(this, new ViewModelFactory(this))
                .get(MovieViewModel.class);

        progressBar = findViewById(R.id.movie_progressBar);  // Reference to the progress bar

        RecyclerView recyclerView = findViewById(R.id.movie_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        movieAdapter = new MovieAdapter();
        recyclerView.setAdapter(movieAdapter);

        observeViewModel();
    }

    private void observeViewModel() {
        movieViewModel.getLoadingState().observe(this, isLoading -> {
            progressBar.setVisibility(isLoading ? View.VISIBLE : View.GONE);
        });

        movieViewModel.getPopularMovies().observe(this, movieModels -> {
            if (movieModels != null) {
                movieAdapter.setMovies(movieModels);
                movieViewModel.setLoadingState(false);
            } else {
                movieViewModel.setLoadingState(true);
            }
        });


        movieViewModel.setLoadingState(true);
    }
}
