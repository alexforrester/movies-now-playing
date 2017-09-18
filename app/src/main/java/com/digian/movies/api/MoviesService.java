package com.digian.movies.api;

import com.digian.movies.model.Collection;
import com.digian.movies.model.Movie;
import com.digian.movies.model.NowPlayingResponse;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by alexforrester on 15/09/2017.
 */

public interface MoviesService {

    @GET("movie/now_playing")
    Observable<NowPlayingResponse> getNowPlayingMovies(@Query("api_key") String api_key, @Query("language") String language, @Query("page") int page, @Query("region") String region);

    @GET("movie/{movie_id}")
    Observable<Movie> getMovie(@Path("movie_id") int movie_id, @Query("api_key") String api_key);

    @GET("collection/{collection_id}")
    Observable<Collection> getCollection(@Path("collection_id") int collection_id, @Query("api_key") String api_key);
}
