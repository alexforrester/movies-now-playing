package com.digian.movies.screens.detail;

import android.graphics.Movie;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.digian.movies.R;

public class MovieDetailActivity extends AppCompatActivity implements MovieDetailContract.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
    }

    //TODO Implement Loading Movie
    @Override
    public void loadMovie(Movie movie) {
        Log.d(MovieDetailActivity.class.getSimpleName(), "Load Movie into view");
    }
}
