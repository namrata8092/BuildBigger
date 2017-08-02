package com.nds.jokeslibrary;

public class WizardJoke {

    public String tellWizardJoke(){
        ManualJoke joke = new ManualJoke();
        return joke.tellJoke()+" using wizard";
    }

}
