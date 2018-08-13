package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    Context context;

    @Before
    public void initialize() {
        context = InstrumentationRegistry.getContext();
    }

    @Test
    public void testJokeIsNonEmptyString() {
        final CountDownLatch latch = new CountDownLatch(1);
        EndpointsAsyncTask testTask = new EndpointsAsyncTask() {
            @Override
            protected void onPostExecute(String result) {
                assertEquals(result, "Joke!");
                latch.countDown();
            }
        };
        testTask.execute(context);

        try {
            latch.await();
        } catch(InterruptedException e) {
            fail();
        }

    }
}
