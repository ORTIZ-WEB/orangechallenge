package com.orangehrmlive.tasks;

import com.orangehrmlive.interactions.Pause;
import com.orangehrmlive.interactions.Wait;
import com.orangehrmlive.uis.RecruitmentPage;
import com.orangehrmlive.uis.SharedElementPage;
import com.orangehrmlive.utils.ExcelReader;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import org.openqa.selenium.Keys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ManageCandidate implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        ArrayList<Map<String, String>> data;

        try {
            data = ExcelReader.readDataFromExcelSheet("src/test/resources/Data/recruitmentdata.xlsx", "interviewinfo");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        actor.attemptsTo(

                Wait.Element(SharedElementPage.btnSuccess),
                Click.on(SharedElementPage.btnSuccess),
                Click.on(SharedElementPage.btnSend),
                Click.on(SharedElementPage.btnSuccess),
                Wait.Element(RecruitmentPage.txtInterviewTitle),
                Enter.theValue(data.get(0).get("title")).into(RecruitmentPage.txtInterviewTitle),
                Enter.theValue(data.get(0).get("interviewer")).into(RecruitmentPage.txtInterviewer),
                Pause.forDuration(2000),
                SendKeys.of(Keys.ARROW_DOWN).into(RecruitmentPage.txtInterviewer),
                SendKeys.of(Keys.ENTER).into(RecruitmentPage.txtInterviewer),
                Enter.theValue(data.get(0).get("date")).into(RecruitmentPage.txtDate),
                Click.on(SharedElementPage.btnSend),
                Wait.Element(SharedElementPage.btnSuccess),
                Click.on(SharedElementPage.btnSuccess),
                Click.on(SharedElementPage.btnSend),
                Click.on(RecruitmentPage.btnOfferJob),
                Pause.forDuration(2000),
                Click.on(SharedElementPage.btnSend),
                Click.on(SharedElementPage.btnSuccess),
                Pause.forDuration(2000),
                Click.on(SharedElementPage.btnSend),
                Pause.forDuration(3000)
        );
    }

    public static Performable on() {
        return instrumented(ManageCandidate.class);
    }

}
