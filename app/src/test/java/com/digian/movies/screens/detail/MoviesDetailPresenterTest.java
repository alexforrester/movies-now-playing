package com.digian.movies.screens.detail;

import android.content.Context;

import com.digian.movies.MoviesApp;
import com.digian.movies.screens.grid.MoviesGridPresenter;
import com.digian.movies.screens.grid.MoviesGridPresenterTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by alexforrester on 17/09/2017.
 */
public class MoviesDetailPresenterTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Mock
    private MoviesDetailContract.View view;

    @Mock
    private MoviesApp moviesApp;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    //Used to bypass mocking error with Dagger
    static class MoviesDetailTestPresenter extends MoviesDetailPresenter {
        public MoviesDetailTestPresenter(Context context) {super(context);}

        @Override
        void injectDependencies(MoviesApp moviesApp) {}
    }

    @Test
    public void given_creating_object_when_null_passed_in_then_exception_thrown() {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("Context cannot be null");

        new MoviesDetailTestPresenter(null).setView(null);
    }

    @Test
    public void given_set_view_method_called_when_null_passed_in_then_exception_thrown() {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("MoviesDetailContract.View cannot be null");

        new MoviesDetailTestPresenter(moviesApp).setView(null);
    }

    @Test
    public void given_set_view_method_called_when_setview_called_then_view_set_in_presenter() {

        MoviesDetailPresenter moviesDetailPresenter = new MoviesDetailTestPresenter(moviesApp);
        moviesDetailPresenter.setView(view);

        assertNotNull(view);
        assertEquals(view, moviesDetailPresenter.view);
    }

}