package com.orangehrmlive.uis;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage{
    public static final Target txtUsername =Target.the("").located(By.name("username"));
    public static final Target txtPassword =Target.the("").located(By.name("password"));

}
