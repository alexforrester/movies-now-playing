package com.digian.movies.di;

import com.digian.movies.screens.detail.MoviesDetailActivity;
import com.digian.movies.screens.detail.MoviesDetailPresenter;
import com.digian.movies.screens.grid.MoviesGridActivity;

import dagger.Subcomponent;

/**
 * Created by alexforrester on 16/09/2017.
 */

@Subcomponent(modules = MoviesDetailModule.class)
public interface MoviesDetailComponent {
    void inject(MoviesDetailActivity target);
    void inject(MoviesDetailPresenter target);
}
