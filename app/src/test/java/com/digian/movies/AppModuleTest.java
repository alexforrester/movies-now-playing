package com.digian.movies;

import com.digian.movies.di.AppModule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by alexforrester on 15/09/2017.
 */
public class AppModuleTest {


    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void given_repository_instantiated_when_null_context_passed_in_then_nullpointer_exception_thrown(){
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("Context cannot be null");

        new AppModule(null);
    }



}