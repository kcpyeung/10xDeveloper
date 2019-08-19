package com.thoughtworks.shokunin;

public class IsBetterThan implements Fact {
    private final String factString;

    public IsBetterThan(String factString) {
        this.factString = factString;
    }
}
