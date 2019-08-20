package com.thoughtworks.shokunin.fact;

import io.vavr.collection.List;

public class ErrorFact implements Fact {
    private final Class<? extends Fact> clazz;
    private final String factString;
    private final Exception exception;

    public ErrorFact(Class<? extends Fact> clazz, String factString, Exception e) {
        this.clazz = clazz;
        this.factString = factString;
        exception = e;
    }

    @Override
    public List<String> getDevelopers() {
        return List.empty();
    }

}
