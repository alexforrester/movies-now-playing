package com.digian.movies.screens.detail;

import android.content.Context;
import android.support.annotation.VisibleForTesting;
import android.util.Log;

import com.digian.movies.MoviesApp;
import com.digian.movies.MoviesRepository;
import com.digian.movies.model.Movie;

import javax.inject.Inject;

/**
 * Created by alexforrester on 15/09/2017.
 */

public class MoviesDetailPresenter implements MoviesDetailContract.Presenter<MoviesDetailContract.View>{

    private static final String TAG = MoviesDetailPresenter.class.getSimpleName();

    @Inject
    MoviesRepository moviesRepository;

    @VisibleForTesting
    MoviesDetailContract.View view;

    public MoviesDetailPresenter(Context context) {
        Log.d(TAG,"MoviesGridPresenter(Context context)");

        if (context == null) {
            throw new NullPointerException("Context cannot be null");
        }

        injectDependencies((MoviesApp) context);
    }

    void injectDependencies(MoviesApp moviesApp) {
        moviesApp.createMoviesDetailComponent().inject(this);
    }

    @Override
    public Movie getMovie(int id) {
        return null;
    }

    @Override
    public void setView(MoviesDetailContract.View view) {

        if (view == null) {
            throw new NullPointerException("MoviesDetailContract.View cannot be null");
        }

        this.view = view;
    }
}
