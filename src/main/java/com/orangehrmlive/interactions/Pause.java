package com.orangehrmlive.interactions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class Pause implements Task {
    private final long duration;

    public Pause(long duration) {
        this.duration = duration;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static Pause forDuration(long duration) {
        return Tasks.instrumented(Pause.class, duration);
    }
}
