package com.orangehrmlive.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class Wait implements Task {

    public static final int TIMEOUT = 60;
    Target Element;

    public Wait(Target element){
        Element = element;
    }

    //@Step("{0} waiting for items")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(Element, WebElementStateMatchers.isVisible()).forNoMoreThan(TIMEOUT).seconds()
        );
    }

    public static Wait Element(Target element){
        return Tasks.instrumented(Wait.class, element);
    }

}
