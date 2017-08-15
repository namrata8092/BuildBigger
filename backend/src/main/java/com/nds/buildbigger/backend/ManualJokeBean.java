package com.nds.buildbigger.backend;

import com.nds.jokeslibrary.ManualJoke;

/**
 * Created by Namrata on 8/9/2017.
 */

public class ManualJokeBean {
    private ManualJoke manualJoke;

    public ManualJokeBean(){
        manualJoke = new ManualJoke();
    }

    public String getManualJoke(){
        return manualJoke.tellJoke();
    }
}
