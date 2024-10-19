package com.orangehrmlive.uis;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {
    public static final Target spanRecruitment = Target.the("").locatedBy("ul li:nth-child(5)");
    public static final Target divName = Target.the("").locatedBy("//div[text()='{0}']");

}
