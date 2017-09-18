package com.digian.movies;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.digian.movies.api.MoviesService;
import com.digian.movies.model.Collection;
import com.digian.movies.model.Movie;
import com.digian.movies.model.NowPlayingResponse;
import com.digian.movies.model.Pages;

import java.util.List;

import io.reactivex.Observable;

import static android.content.ContentValues.TAG;

/**
 * Created by alexforrester on 15/09/2017.
 */

public class MoviesRepositoryImpl implements MoviesRepository {

    private final SharedPreferences sharedPreferences;
    private final Context context;
    private final MoviesService moviesService;
    private final Pages pages;

    public MoviesRepositoryImpl(Context context, MoviesService moviesService, SharedPreferences sharedPreferences) {
        Log.d(TAG,"MoviesRepositoryImpl(Context context, MoviesService moviesService, SharedPreferences sharedPreferences)");

        if (context == null) {
            throw new NullPointerException("Context cannot be null");
        }

        if (moviesService == null) {
            throw new NullPointerException("MoviesService cannot be null");
        }

        if (sharedPreferences == null) {
            throw new NullPointerException("SharedPreferences cannot be null");
        }

        this.moviesService = moviesService;
        this.context = context;
        this.sharedPreferences = sharedPreferences;
        this.pages = new Pages(sharedPreferences);
    }

    @Override
    public Observable<Movie> getMovie(int movieId) {
        Log.d(TAG,"getMovie(int id)");

        return moviesService.getMovie(movieId, Constants.THE_MOVIE_DB_API_KEY);
    }

    @Override
    public Observable<Collection> getMovieCollection(int collectionId) {
        Log.d(TAG,"getMovieCollection(int collectionId)");
        return moviesService.getCollection(collectionId, Constants.THE_MOVIE_DB_API_KEY);
    }

    @Override
    public Observable<NowPlayingResponse> getMoviesPlayingNow(int pageNo) {
        Log.d(TAG,"getMoviesPlayingNow(int pageNo)");

        int validatedPageNo = pages.getValidatedPageNo(pageNo);
        Log.d(TAG,String.format("validatedPageNo: %d",validatedPageNo));

        //TODO - Localise Language and Region
        return moviesService.getNowPlayingMovies(Constants.THE_MOVIE_DB_API_KEY, Constants.DEFAULT_LANGUAGE, validatedPageNo, Constants.DEFAULT_REGION);
    }

    @Override
    public Pages getPages() {
        return pages;
    }

    @Override
    public void setPages(int pageNo, int totalPages) {
        pages.setPageNo(pageNo);
        pages.setTotalPages(totalPages);
    }


}
