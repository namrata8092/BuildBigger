package com.nds.gradle.master.buildbigger;

import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
/**
 * Created by Namrata on 8/18/2017.
 */
@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest extends AndroidTestCase {

    @Test
    public void test(){
        EndpointsAsyncTask endpointsAsyncTask =
                new EndpointsAsyncTask(getContext(),null);
        String joke = null;
        endpointsAsyncTask.execute();
        try{
            joke = endpointsAsyncTask.get();
        }catch (Exception e){

        }
        assertNotNull(joke);
    }
}
