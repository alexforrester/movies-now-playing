package com.digian.movies;


import com.digian.movies.model.Collection;
import com.digian.movies.model.Movie;
import com.digian.movies.model.NowPlayingResponse;
import com.digian.movies.model.Pages;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by alexforrester on 15/09/2017.
 */

public interface MoviesRepository {

    Observable<Movie> getMovie(int id);

    Observable<Collection> getMovieCollection(int collectionId);

    Observable<NowPlayingResponse> getMoviesPlayingNow(int pageNo);
    Pages getPages();
    void setPages(int page, int totalPages);
}
