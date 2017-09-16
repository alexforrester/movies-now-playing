package com.digian.movies;

import android.content.Context;

import com.digian.movies.api.MoviesService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by alexforrester on 15/09/2017.
 */

@Module
public class MoviesAppModule {

    private final Context context;

    public MoviesAppModule(Context context) {

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
    Retrofit provideRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(Constants.THE_MOVIE_DB_API_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    MoviesService provideMoviesService(Retrofit retrofit) {
        return retrofit.create(MoviesService.class);
    }

    @Provides
    @Singleton
    MovieRepository provideMovieRepository(Context context, MoviesService moviesService) {
        return new MovieRepositoryImpl(context,moviesService);
    }
}