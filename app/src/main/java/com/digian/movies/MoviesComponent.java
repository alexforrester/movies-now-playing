package com.digian.movies;

import com.digian.movies.screens.detail.MovieDetailPresenter;
import com.digian.movies.screens.grid.MovieGridPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by alexforrester on 15/09/2017.
 */

@Singleton
@Component(modules = MoviesAppModule.class)
public interface MoviesComponent {
    void inject (MovieDetailPresenter movieDetailPresenter);
    void inject (MovieGridPresenter movieGridPresenter);
}
