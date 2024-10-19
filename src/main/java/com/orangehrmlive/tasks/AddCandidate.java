package com.orangehrmlive.tasks;

import com.orangehrmlive.interactions.Wait;
import com.orangehrmlive.uis.HomePage;
import com.orangehrmlive.uis.LoginPage;
import com.orangehrmlive.uis.RecruitmentPage;
import com.orangehrmlive.uis.SharedElementPage;
import com.orangehrmlive.utils.ExcelReader;
import io.appium.java_client.android.nativekey.PressesKey;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.actions.Upload;
import org.openqa.selenium.Keys;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddCandidate implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        ArrayList<Map<String, String>> data;

        try {
            data = ExcelReader.readDataFromExcelSheet("src/test/resources/Data/recruitmentdata.xlsx", "candidateinfo");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        actor.attemptsTo(
                Wait.Element(HomePage.spanRecruitment),
                Click.on(HomePage.spanRecruitment),
                Wait.Element(RecruitmentPage.btnAdd),
                Click.on(RecruitmentPage.btnAdd),
                Wait.Element(RecruitmentPage.txtFirstName),
                Enter.theValue(data.get(0).get("firstname")).into(RecruitmentPage.txtFirstName),
                Enter.theValue(data.get(0).get("middlename")).into(RecruitmentPage.txtMiddleName),
                Enter.theValue(data.get(0).get("lastname")).into(RecruitmentPage.txtLastName),
                Click.on(RecruitmentPage.btnVacancy),
                SendKeys.of(Keys.ARROW_DOWN).into(RecruitmentPage.selectVacancy),
                SendKeys.of(Keys.ARROW_DOWN).into(RecruitmentPage.selectVacancy),
                SendKeys.of(Keys.ENTER).into(RecruitmentPage.selectVacancy),
                Enter.theValue(data.get(0).get("email")).into(RecruitmentPage.txtEmail),
                Enter.theValue(data.get(0).get("number")).into(RecruitmentPage.txtNumber),
                Upload.theFile(Paths.get("src/test/resources/data/test.docx")).to(RecruitmentPage.btnResume),
                Enter.theValue(data.get(0).get("keywords")).into(RecruitmentPage.txtKeywords),
                Enter.theValue(data.get(0).get("notes")).into(RecruitmentPage.txtNote),
                Click.on(RecruitmentPage.btnCheck),
                Click.on(SharedElementPage.btnSend)
        );
    }

    public static Performable on(){
        return instrumented(AddCandidate.class);
    }
}
