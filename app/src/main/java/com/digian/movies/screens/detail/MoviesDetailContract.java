package com.digian.movies.screens.detail;


import com.digian.movies.model.Movie;

/**
 * Created by alexforrester on 15/09/2017.
 */

public interface MoviesDetailContract {

    interface Presenter<T extends MoviesDetailContract.View> {
        Movie getMovie(int id);
        void setView(T view);
    }

    interface View {
        void loadMovie(Movie movie);
    }
}
