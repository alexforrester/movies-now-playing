package com.digian.movies.model;

import android.content.SharedPreferences;
import android.support.annotation.VisibleForTesting;
import android.util.Log;

import com.digian.movies.Constants;

import static android.content.ContentValues.TAG;
import static com.digian.movies.Constants.THE_MOVIE_DB_DEFAULT_PAGE_NO;
import static com.digian.movies.Constants.THE_MOVIE_DB_PAGE_NUMBER_UNDEFINED;

/**
 * Created by alexforrester on 17/09/2017.
 */

public class Pages {

    private final SharedPreferences sharedPreferences;
    int pageNo;
    int totalPages;

    public Pages(SharedPreferences sharedPreferences){
        this.sharedPreferences = sharedPreferences;
    }

    public void setTotalPages(int totalPages) {
        Log.d(TAG,String.format("setTotalPages(int %d)",totalPages));
        sharedPreferences.edit().putInt(Constants.THE_MOVIE_DB_TOTAL_PAGE_NO,totalPages).apply();
        this.totalPages = totalPages;
    }

    public int getTotalPages() {
        Log.d(TAG,"getTotalPages");
        return sharedPreferences.getInt(Constants.THE_MOVIE_DB_TOTAL_PAGE_NO,THE_MOVIE_DB_DEFAULT_PAGE_NO);
    }

    public int getValidatedPageNo(int pageNoToValidate) {
        Log.d(TAG,String.format("getValidatedPageNo(%d)",pageNoToValidate));
        return pageNoToValidate == THE_MOVIE_DB_PAGE_NUMBER_UNDEFINED ? getPageNo() : pageNoToValidate;
    }

    public int getPageNo() {
        Log.d(TAG,"getPageNo");
        return sharedPreferences.getInt(Constants.THE_MOVIE_DB_PAGE_NO,Constants.THE_MOVIE_DB_DEFAULT_PAGE_NO);
    }

    public void setPageNo(int pageNo) {
        Log.d(TAG,String.format("setPageNo(%d)",pageNo));
        sharedPreferences.edit().putInt(Constants.THE_MOVIE_DB_PAGE_NO,pageNo).apply();
        this.pageNo = pageNo;
    }




}
