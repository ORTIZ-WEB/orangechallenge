package com.orangehrmlive.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ResultVerification implements Question<Boolean> {

    public Target Element;
    public String Search;

    public ResultVerification(Target element, String search) {

        Element = element;
        Search = search;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Element.of(Search).resolveFor(actor).isVisible();
    }

    public static ResultVerification isVisible(Target element, String search) {
        return new ResultVerification(element, search);
    }

}