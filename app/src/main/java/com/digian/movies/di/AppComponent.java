package com.digian.movies.di;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by alexforrester on 15/09/2017.
 */

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {

    MoviesGridComponent plus(MoviesGridModule moviesGridModule);
    MoviesDetailComponent plus(MoviesDetailModule moviesDetailModule);

}
