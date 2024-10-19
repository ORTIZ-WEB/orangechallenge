package com.orangehrmlive.stepdefinitions;

import com.orangehrmlive.questions.ResultVerification;
import com.orangehrmlive.tasks.AddCandidate;
import com.orangehrmlive.uis.RecruitmentPage;
import com.orangehrmlive.utils.ExcelReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AddCandidateStepDefinitions {

    @And("the user adds a new candidate")
    public void theUserAddsANewCandidate() {
        theActorInTheSpotlight().attemptsTo(AddCandidate.on());
    }

    @Then("the user sees the candidate's information")
    public void userSeesCandidateInfo() {

        ArrayList<Map<String, String>> data;

        try {
            data = ExcelReader.readDataFromExcelSheet("src/test/resources/Data/recruitmentdata.xlsx", "candidateinfo");
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }

        String name = data.get(0).get("name");
        String vacancy = data.get(0).get("vacancy");
        String status = data.get(0).get("status");

        theActorInTheSpotlight().should(seeThat(ResultVerification.isVisible(RecruitmentPage.pVacancyInfo, name)));
        theActorInTheSpotlight().should(seeThat(ResultVerification.isVisible(RecruitmentPage.pVacancyInfo, vacancy)));
        theActorInTheSpotlight().should(seeThat(ResultVerification.isVisible(RecruitmentPage.pVacancyInfo, status)));
    }
}
