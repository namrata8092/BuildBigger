package com.nds.jokesandroidlibrary;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Namrata Shah on 7/31/2017.
 */

public final class DisplayUtil {
    private DisplayUtil(){}

    public static final void displayJoke(String msg, Context context){
        Intent destinationIntent = new Intent(context, DisplayJokeActivity.class);
        destinationIntent.putExtra(DisplayJokeActivity.JOKE_KEY, msg);
        context.startActivity(destinationIntent);
    }
}
