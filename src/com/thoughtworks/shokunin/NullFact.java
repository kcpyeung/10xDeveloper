package com.thoughtworks.shokunin;

public class NullFact implements Fact {
    private final String factString;

    public NullFact(String factString) {
        this.factString = factString;
    }
}
