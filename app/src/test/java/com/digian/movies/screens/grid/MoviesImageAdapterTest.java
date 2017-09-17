package com.digian.movies.screens.grid;

import android.content.Context;

import com.digian.movies.model.MovieGridImage;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by alexforrester on 17/09/2017.
 */
public class MoviesImageAdapterTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Mock
    Context context;

    @Mock
    List<MovieGridImage> movieGridImages;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void give_adapter_created_when_null_context_passed_in_then_null_pointer_exception_thrown() {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("Context cannot be null");

        new MoviesImageAdapter(null, movieGridImages);
    }

    @Test
    public void give_adapter_created_when_null_image_list_passed_in_then_null_pointer_exception_thrown() {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("List<MovieGridImage> cannot be null");

        new MoviesImageAdapter(context, null);
    }

    @Test
    public void give_adapter_created_when_context_passed_in_then_check_set_as_field() {

        MoviesImageAdapter moviesImageAdapter = new MoviesImageAdapter(context, movieGridImages);

        assertNotNull(moviesImageAdapter.context);
        assertEquals(context,moviesImageAdapter.context);
    }

    @Test
    public void give_adapter_created_when_image_list_passed_in_then_check_set_as_field() {

        MoviesImageAdapter moviesImageAdapter = new MoviesImageAdapter(context, movieGridImages);

        assertNotNull(moviesImageAdapter.movieGridImages);
        assertEquals(movieGridImages,moviesImageAdapter.movieGridImages);
    }



}