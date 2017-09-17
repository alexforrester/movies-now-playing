package com.digian.movies;

import android.app.Application;

import com.digian.movies.di.AppComponent;
import com.digian.movies.di.AppModule;
import com.digian.movies.di.DaggerAppComponent;
import com.digian.movies.di.MoviesDetailComponent;
import com.digian.movies.di.MoviesDetailModule;
import com.digian.movies.di.MoviesGridComponent;
import com.digian.movies.di.MoviesGridModule;
import com.digian.movies.di.NetworkModule;

/**
 * Created by alexforrester on 15/09/2017.
 */

public class MoviesApp extends Application {

    AppComponent appComponent;

    MoviesDetailComponent moviesDetailComponent;
    MoviesGridComponent moviesGridComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).networkModule(new NetworkModule()).build();
    }

    public MoviesDetailComponent createMoviesDetailComponent(){
        return appComponent.plus(new MoviesDetailModule());
    }

    public void releaseMoviesDetailComponent(){
        moviesDetailComponent = null;
    }

    public MoviesGridComponent createMoviesGridComponent(){
        return appComponent.plus(new MoviesGridModule());
    }

    public void releaseMoviesGridComponent(){
        moviesGridComponent = null;
    }


}
