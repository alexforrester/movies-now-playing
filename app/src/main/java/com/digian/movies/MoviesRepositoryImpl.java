package com.digian.movies;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Movie;
import android.support.annotation.VisibleForTesting;
import android.util.Log;

import com.digian.movies.api.MoviesService;
import com.digian.movies.model.NowPlayingResponse;

import java.util.List;
import java.util.Locale;

import dagger.Component;
import io.reactivex.Observable;

import static android.content.ContentValues.TAG;
import static com.digian.movies.Constants.THE_MOVIE_DB_PAGE_NUMBER_UNDEFINED;

/**
 * Created by alexforrester on 15/09/2017.
 */

public class MoviesRepositoryImpl implements MoviesRepository {

    private final SharedPreferences sharedPreferences;
    private final Context context;
    final MoviesService moviesService;

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
    }

    //TODO Implement
    @Override
    public Movie getMovie(int id) {
        return null;
    }


    @Override
    public Observable<NowPlayingResponse> getMoviesPlayingNow(int pageNo) {
        Log.d(TAG,"getMoviesPlayingNow(int pageNo)");

        int validatedPageNo = getValidatedPageNo(pageNo);
        Log.d(TAG,String.format("validatedPageNo: %d",validatedPageNo));

        //TODO - Localise Language and Region
        return moviesService.getNowPlayingMovies(Constants.THE_MOVIE_DB_API_KEY, Constants.DEFAULT_LANGUAGE, validatedPageNo, Constants.DEFAULT_REGION);
    }

    @VisibleForTesting
    int getValidatedPageNo(int pageNo) {
        Log.d(TAG,String.format("getValidatedPageNo(%d)",pageNo));
        return pageNo == THE_MOVIE_DB_PAGE_NUMBER_UNDEFINED ? getSavedPageNo() : pageNo;
    }

    @VisibleForTesting
    int getSavedPageNo() {
        Log.d(TAG,"getSavedPageNo()");
        return sharedPreferences.getInt(Constants.THE_MOVIE_DB_PAGE_NO,Constants.THE_MOVIE_DB_DEFAULT_PAGE_NO);
    }

    @Override
    public void setPageNo(int pageNo) {
        Log.d(TAG,String.format("setPageNo(%d)",pageNo));
        sharedPreferences.edit().putInt(Constants.THE_MOVIE_DB_PAGE_NO,pageNo);
    }

}
