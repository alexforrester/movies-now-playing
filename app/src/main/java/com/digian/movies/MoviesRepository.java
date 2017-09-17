package com.digian.movies;

import android.graphics.Movie;

import com.digian.movies.model.NowPlayingResponse;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by alexforrester on 15/09/2017.
 */

public interface MoviesRepository {
    Movie getMovie(int id);
    Observable<NowPlayingResponse> getMoviesPlayingNow(int pageNo);
    void setPageNo(int pageNo);
}
