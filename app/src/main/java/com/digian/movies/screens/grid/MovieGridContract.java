package com.digian.movies.screens.grid;

import android.graphics.Movie;

import java.util.List;

/**
 * Created by alexforrester on 15/09/2017.
 */

public class MovieGridContract {

    interface Presenter<T extends MovieGridContract.View> {
        List<Movie> getMoviesPlayingNow();
    }

    interface View {
        void loadMovies(List<Movie> movies);
    }
}
