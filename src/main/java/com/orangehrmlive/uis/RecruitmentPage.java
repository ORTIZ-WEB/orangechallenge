package com.orangehrmlive.uis;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RecruitmentPage {
    public static final Target btnAdd =Target.the("").located(By.xpath("//button[@data-v-10d463b7 and @type='button']"));
    public static final Target txtFirstName =Target.the("").located(By.name("firstName"));
    public static final Target txtMiddleName =Target.the("").located(By.name("middleName"));
    public static final Target txtLastName =Target.the("").located(By.name("lastName"));
    public static final Target btnVacancy =Target.the("").locatedBy("//div[@class='oxd-select-text--after']");
    public static final Target selectVacancy =Target.the("").locatedBy("//div[@class='oxd-select-text-input']");
    public static final Target txtEmail =Target.the("").located(By.xpath("(//input[@placeholder='Type here'])[1]"));
    public static final Target txtNumber =Target.the("").located(By.xpath("(//input[@placeholder='Type here'])[2]"));
    public static final Target btnResume =Target.the("").locatedBy("//input[@type='file']");
    public static final Target txtKeywords =Target.the("").locatedBy("//input[@placeholder='Enter comma seperated words...']");
    public static final Target txtDate =Target.the("").locatedBy("//input[@placeholder='yyyy-dd-mm']");
    public static final Target txtNote =Target.the("").locatedBy("//textarea");
    public static final Target btnCheck =Target.the("").locatedBy("//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']");
    public static final Target txtInterviewTitle = Target.the("").locatedBy("div.oxd-form-row:nth-child(2) div:nth-child(2) > input.oxd-input.oxd-input--active");
    public static final Target txtInterviewer =Target.the("").locatedBy("//input[@placeholder='Type for hints...']");
    public static final Target btnOfferJob =Target.the("").locatedBy("//button[contains(@class , 'button--success')][2]");
    public static Target pVacancyInfo =Target.the("").locatedBy("//p[text()='{0}']");
    public static final Target pVacancyInfoName =Target.the("").locatedBy("//p[text()='Jhon Mike Scott']");
}
