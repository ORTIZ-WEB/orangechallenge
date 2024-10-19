package com.orangehrmlive.tasks;

import com.orangehrmlive.interactions.Wait;
import com.orangehrmlive.uis.LoginPage;
import com.orangehrmlive.uis.SharedElementPage;
import com.orangehrmlive.utils.ExcelReader;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {

@Override
public <T extends Actor> void performAs(T actor) {

    ArrayList<Map<String, String>> data;

    try {
        data = ExcelReader.readDataFromExcelSheet("src/test/resources/Data/recruitmentdata.xlsx", "datalogin");
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

    actor.attemptsTo(
            Wait.Element(LoginPage.txtUsername),
            Enter.theValue(data.get(0).get("username")).into(LoginPage.txtUsername),
            Enter.theValue(data.get(0).get("password")).into(LoginPage.txtPassword),
            Click.on(SharedElementPage.btnSend)
    );
}
    public static Performable on(){
        return instrumented(Login.class);
    }

}
