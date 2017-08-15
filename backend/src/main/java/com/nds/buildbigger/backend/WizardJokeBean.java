package com.nds.buildbigger.backend;

import com.nds.jokeslibrary.ManualJoke;
import com.nds.jokeslibrary.WizardJoke;

/**
 * Created by Namrata on 8/9/2017.
 */

public class WizardJokeBean {
    private WizardJoke wizardJoke;

    public WizardJokeBean(){
        wizardJoke = new WizardJoke();
    }

    public String getWizardJoke(){
        return wizardJoke.tellWizardJoke();
    }
}
