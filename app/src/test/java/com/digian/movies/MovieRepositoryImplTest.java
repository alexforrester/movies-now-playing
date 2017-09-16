package com.digian.movies;

import android.content.Context;

import com.digian.movies.api.MoviesService;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Created by alexforrester on 15/09/2017.
 */
public class MovieRepositoryImplTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Mock
    Context context;

    @Mock
    MoviesService moviesService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void given_repository_instantiated_when_null_context_passed_in_then_nullpointer_exception_thrown(){
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("Context cannot be null");

        new MovieRepositoryImpl(null, moviesService);
    }

    @Test
    public void given_repository_instantiated_when_null_moviesservice_passed_in_then_nullpointer_exception_thrown(){
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("MoviesService cannot be null");

        new MovieRepositoryImpl(context, null);
    }

}