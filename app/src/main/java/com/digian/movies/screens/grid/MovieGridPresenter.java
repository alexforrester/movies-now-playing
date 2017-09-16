package com.digian.movies.screens.grid;

/**
 * Created by alexforrester on 15/09/2017.
 */

import android.graphics.Movie;

import com.digian.movies.MovieRepository;

import java.util.List;

import javax.inject.Inject;

public class MovieGridPresenter implements MovieGridContract.Presenter<MovieGridContract.View>{

    @Inject
    MovieRepository movieRepository;

    @Override
    public List<Movie> getMoviesPlayingNow() {
        return null;
    }
}
