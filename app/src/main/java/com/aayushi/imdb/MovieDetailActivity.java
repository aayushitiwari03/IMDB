package com.aayushi.imdb;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import com.aayushi.imdb.remote.model.Movie;
import com.bumptech.glide.Glide;

public class MovieDetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        // Get the movie object from the intent
        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        // Find views
        ImageView posterImageView = findViewById(R.id.detailPosterImageView);
        TextView titleTextView = findViewById(R.id.detailTitleTextView);
        TextView overviewTextView = findViewById(R.id.detailOverviewTextView);
        TextView releaseDateTextView = findViewById(R.id.detailReleaseDateTextView);
        TextView ratingTextView = findViewById(R.id.detailRatingTextView);
        TextView popularityTextView = findViewById(R.id.detailPopularityTextView);

        // Set values to views
        titleTextView.setText(movie.getTitle());
        overviewTextView.setText(movie.getOverview());
        releaseDateTextView.setText("Release Date: " + movie.getReleaseDate());
        //ratingTextView.setText("Rating: " + movie.());  // Replace with actual rating attribute
       // popularityTextView.setText("Popularity: " + movie.getPopularity());  // Replace with actual popularity attribute

        // Load image using Glide
        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500" + movie.getPosterPath())
                .into(posterImageView);
    }
}
