package com.digian.movies;

import android.content.Context;
import android.content.SharedPreferences;

import com.digian.movies.api.MoviesService;
import com.digian.movies.model.NowPlayingResponse;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.Observable;
import retrofit2.http.Query;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by alexforrester on 15/09/2017.
 */
public class MoviesRepositoryImplTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Mock
    Context context;

    @Mock
    MoviesService moviesService;

    @Mock
    SharedPreferences sharedPreferences;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void given_repository_instantiated_when_null_context_passed_in_then_nullpointer_exception_thrown(){
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("Context cannot be null");

        new MoviesRepositoryImpl(null, moviesService, sharedPreferences);
    }

    @Test
    public void given_repository_instantiated_when_null_moviesservice_passed_in_then_nullpointer_exception_thrown(){
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("MoviesService cannot be null");

        new MoviesRepositoryImpl(context, null, sharedPreferences);
    }

    @Test
    public void given_repository_instantiated_when_null_sharedPreferences_passed_in_then_nullpointer_exception_thrown(){
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("SharedPreferences cannot be null");

        new MoviesRepositoryImpl(context, moviesService, null);
    }





}