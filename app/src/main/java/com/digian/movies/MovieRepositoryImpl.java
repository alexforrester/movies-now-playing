package com.digian.movies;

import android.content.Context;
import android.graphics.Movie;

import com.digian.movies.api.MoviesService;

import java.util.List;

/**
 * Created by alexforrester on 15/09/2017.
 */

public class MovieRepositoryImpl implements MovieRepository{

    private Context context;
    private MoviesService moviesService;

    public MovieRepositoryImpl(Context context, MoviesService moviesService) {

        if (context == null) {
            throw new NullPointerException("Context cannot be null");
        }

        if (moviesService == null) {
            throw new NullPointerException("MoviesService cannot be null");
        }

        this.moviesService = moviesService;
        this.context = context;
    }

    //TODO - To implement
    @Override
    public Movie getMovie(int id) {
        return null;
    }

    //TODO - To implement
    @Override
    public List<Movie> getMoviesPlayingNow() {
        return null;
    }
}
