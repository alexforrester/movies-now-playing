package com.digian.movies;

/**
 * Created by alexforrester on 15/09/2017.
 */

public class Constants {

	//TODO - Please replace with your own key
    public static final String THE_MOVIE_DB_API_KEY = "";
    public static final String THE_MOVIE_DB_API_ENDPOINT = "https://api.themoviedb.org/3/";
    public static final String THE_MOVIE_DB_PAGE_NO = "THE_MOVIE_DB_PAGE_NO";
    public static final String THE_MOVIE_DB_TOTAL_PAGE_NO = "THE_MOVIE_DB_TOTAL_PAGE_NO";
    public static final int THE_MOVIE_DB_PAGE_NUMBER_UNDEFINED = 0;
    public static final int THE_MOVIE_DB_DEFAULT_PAGE_NO = 1;
    public static final String DEFAULT_LANGUAGE = "en-UK";
    public static final String DEFAULT_REGION = "GB";
    public static final String THE_MOVIE_DB_MOVIE_ID = "THE_MOVIE_DB_MOVIE_ID";
    public static final int THE_MOVIE_DB_MOVIE_DEFAULT_ID = 0;

    public class Images {
        //TODO - update when app starts and store in shared preferences as can change every few days
        public static final String BASE_IMAGE_URL = "http://image.tmdb.org/t/p/";
        public static final String POSTER_SIZE_GRID_VIEW = "w154";
        public static final String POSTER_SIZE_DETAIL_VIEW = "w500";
    }

}
