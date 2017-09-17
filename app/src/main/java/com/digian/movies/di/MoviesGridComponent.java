package com.digian.movies.di;

import com.digian.movies.screens.grid.MoviesGridActivity;
import com.digian.movies.screens.grid.MoviesGridPresenter;

import dagger.Subcomponent;

/**
 * Created by alexforrester on 16/09/2017.
 */

@Subcomponent(modules = MoviesGridModule.class)
public interface MoviesGridComponent {
    void inject(MoviesGridActivity target);
    void inject(MoviesGridPresenter target);
}
