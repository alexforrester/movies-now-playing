package com.digian.movies.screens.detail;


import com.digian.movies.model.Movie;
import com.digian.movies.model.Part;

import java.util.List;

/**
 * Created by alexforrester on 15/09/2017.
 */

public interface MoviesDetailContract {

    interface Presenter<T extends MoviesDetailContract.View> {
        void getMovie(int id);
        void setView(T view);
    }

    interface View {
        void loadMovie(Movie movie);
        void showError(String message);
        void displayCollection(List<Part> parts);
    }
}
