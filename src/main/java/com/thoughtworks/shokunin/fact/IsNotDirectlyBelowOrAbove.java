package com.thoughtworks.shokunin.fact;

public class IsNotDirectlyBelowOrAbove implements Fact {
    private final String factString;

    public IsNotDirectlyBelowOrAbove(String factString) {
        this.factString = factString;
    }
}
