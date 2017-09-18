package com.digian.movies.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.digian.movies.Constants;
import com.digian.movies.MoviesRepositoryImpl;
import com.digian.movies.api.MoviesService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.digian.movies.Constants.THE_MOVIE_DB_DEFAULT_PAGE_NO;
import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by alexforrester on 17/09/2017.
 */
public class PagesTest {

    @Mock
    Context context;

    @Mock
    SharedPreferences sharedPreferences;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void given_pageno_set_as_zero_when_pageno_validated_then_page_one_returned(){

        Pages pages = spy(new Pages(sharedPreferences));

        int pageNo = pages.getValidatedPageNo(Constants.THE_MOVIE_DB_PAGE_NUMBER_UNDEFINED);

        assertEquals(Constants.THE_MOVIE_DB_DEFAULT_PAGE_NO, pageNo);
    }


}