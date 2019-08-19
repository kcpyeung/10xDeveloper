package com.thoughtworks.shokunin.fact;

public class ErrorFact implements Fact {
    private final Exception exception;

    public ErrorFact(Exception e) {
        exception = e;
    }
}
