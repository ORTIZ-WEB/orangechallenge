package com.orangehrmlive.uis;

import net.serenitybdd.screenplay.targets.Target;

public class SharedElementPage {

    public static final Target btnSuccess =Target.the("").locatedBy("//button[contains(@class , 'button--success')]");
    public static final Target btnSend =Target.the("").locatedBy("//button[@type='submit']");
}
