/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.nds.buildbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "jokeApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.buildbigger.nds.com",
                ownerName = "backend.buildbigger.nds.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    @ApiMethod(name = "getManualJoke")
    public ManualJokeBean getManualJoke() {
        ManualJokeBean manualJokeBean = new ManualJokeBean();
        return manualJokeBean;
    }

    @ApiMethod(name = "getWizardJoke")
    public WizardJokeBean getWizardJoke() {
        WizardJokeBean wizardlJokeBean = new WizardJokeBean();
        return wizardlJokeBean;
    }

}
