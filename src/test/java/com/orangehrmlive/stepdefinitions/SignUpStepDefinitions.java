package com.orangehrmlive.stepdefinitions;

import com.orangehrmlive.tasks.Login;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class SignUpStepDefinitions {

    @Before
    public void setStage(){
        OnStage.setTheStage(new OnlineCast());
        WebDriverManager.chromedriver().setup();
    }

    @Given("the user opens the Orange site")
    public void theUserOpensTheOrangeSite() {
        theActorCalled("User").wasAbleTo(Open.url("https://opensource-demo.orangehrmlive.com/web/index.php"));
    }
    @When("the user signs up with a username and password")
    public void theUserSingsUpWithAUsernameAndPassword() {
        theActorInTheSpotlight().attemptsTo(Login.on());
    }

}

