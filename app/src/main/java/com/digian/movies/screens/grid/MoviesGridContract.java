package com.digian.movies.screens.grid;

import com.digian.movies.model.MovieGridImage;

import java.util.List;

/**
 * Created by alexforrester on 15/09/2017.
 */

public class MoviesGridContract {

    interface Presenter<T extends MoviesGridContract.View> {
        void getMoviesPlayingNow(int pageNo);
        void setView(T view);
    }

    interface View {
        void loadMovies(List<MovieGridImage> movies);
        void showError(String error);
    }
}
