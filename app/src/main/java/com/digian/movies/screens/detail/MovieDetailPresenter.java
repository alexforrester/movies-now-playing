package com.digian.movies.screens.detail;

import android.graphics.Movie;

import com.digian.movies.MovieRepository;

import javax.inject.Inject;

/**
 * Created by alexforrester on 15/09/2017.
 */

public class MovieDetailPresenter implements MovieDetailContract.Presenter<MovieDetailContract.View>{

    @Inject
    MovieRepository movieRepository;

    @Override
    public Movie getMovie(int id) {
        return null;
    }
}
