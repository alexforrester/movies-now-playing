package com.digian.movies.screens.grid;

import android.content.Context;
import android.util.Log;

import com.digian.movies.MoviesApp;
import com.digian.movies.MoviesRepositoryImpl;
import com.digian.movies.screens.detail.MoviesDetailContract;
import com.digian.movies.screens.detail.MoviesDetailPresenter;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

/**
 * Created by alexforrester on 17/09/2017.
 */
public class MoviesGridPresenterTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Mock
    private MoviesGridContract.View view;

    @Mock
    private MoviesApp moviesApp;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    //Used to bypass mocking error with Dagger
    static class MoviesGridTestPresenter extends MoviesGridPresenter {
        public MoviesGridTestPresenter(Context context) {super(context);}

        @Override
        void injectDependencies(MoviesApp moviesApp) {}
    }

    @Test
    public void given_creating_object_when_null_passed_in_then_exception_thrown() {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("Context cannot be null");

        new MoviesGridTestPresenter(null).setView(null);
    }

    @Test
    public void given_set_view_method_called_when_null_passed_in_then_exception_thrown() {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("MoviesGridContract.View cannot be null");

        new MoviesGridTestPresenter(moviesApp).setView(null);
    }

    @Test
    public void given_set_view_method_called_when_setview_called_then_view_set_in_presenter() {

        MoviesGridPresenter moviesGridPresenter = new MoviesGridTestPresenter(moviesApp);
        moviesGridPresenter.setView(view);

        assertNotNull(view);
        assertEquals(view, moviesGridPresenter.view);
    }

}