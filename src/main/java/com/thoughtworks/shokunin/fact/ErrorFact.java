package com.thoughtworks.shokunin.fact;

public class ErrorFact implements Fact {
    private final Class<? extends Fact> clazz;
    private final String factString;
    private final Exception exception;

    public ErrorFact(Class<? extends Fact> clazz, String factString, Exception e) {
        this.clazz = clazz;
        this.factString = factString;
        exception = e;
    }
}
