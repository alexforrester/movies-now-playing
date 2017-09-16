package com.digian.movies.screens.detail;

import android.graphics.Movie;

/**
 * Created by alexforrester on 15/09/2017.
 */

public interface MovieDetailContract {

    interface Presenter<T extends MovieDetailContract.View> {
        Movie getMovie(int id);
    }

    interface View {
        void loadMovie(Movie movie);
    }
}
