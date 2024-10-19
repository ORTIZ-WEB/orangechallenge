package com.orangehrmlive.stepdefinitions;

import com.orangehrmlive.tasks.ManageCandidate;
import io.cucumber.java.en.And;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ManageStepDefinitions {

    @And("the user manages a candidate")
    public void theUserManagesACandidate() {
        theActorInTheSpotlight().attemptsTo(ManageCandidate.on());
    }

}
