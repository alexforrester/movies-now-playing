package com.digian.movies.di;

import android.content.Context;
import android.content.SharedPreferences;

import com.digian.movies.MoviesRepository;
import com.digian.movies.MoviesRepositoryImpl;
import com.digian.movies.api.MoviesService;
import com.digian.movies.screens.grid.MoviesGridPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by alexforrester on 16/09/2017.
 */

@Module
public class MoviesGridModule {

    @Provides
    public MoviesGridPresenter providesMovieGridPresenter(Context context) {
        return new MoviesGridPresenter(context);
    }

}
