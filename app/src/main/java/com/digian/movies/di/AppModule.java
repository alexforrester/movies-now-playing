package com.digian.movies.di;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.digian.movies.MoviesRepository;
import com.digian.movies.MoviesRepositoryImpl;
import com.digian.movies.api.MoviesService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by alexforrester on 15/09/2017.
 */

@Module
public class AppModule {

    private final Context context;

    public AppModule(Context context) {

        if (context == null) {
            throw new NullPointerException("Context cannot be null");
        }

        this.context = context;
    }

    @Provides
    @Singleton
    public Context providesContext() {
        return context;
    }

    @Provides
    @Singleton
    public SharedPreferences providesDefaultSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides
    @Singleton
    public MoviesRepository provideMovieRepository(Context context, MoviesService moviesService, SharedPreferences sharedPreferences) {
        return new MoviesRepositoryImpl(context, moviesService, sharedPreferences);
    }

}