package com.digian.movies.api;

import com.digian.movies.model.NowPlayingResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by alexforrester on 15/09/2017.
 */

public interface MoviesService {

    @GET("movie/now_playing")
    Observable<NowPlayingResponse> getNowPlayingMovies(@Query("api_key") String api_key, @Query("language") String language, @Query("page") int page, @Query("region") String region);
}
