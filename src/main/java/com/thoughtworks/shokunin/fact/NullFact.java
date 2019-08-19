package com.thoughtworks.shokunin.fact;

public class NullFact implements Fact {
    private final String factString;

    public NullFact(String factString) {
        this.factString = factString;
    }
}
