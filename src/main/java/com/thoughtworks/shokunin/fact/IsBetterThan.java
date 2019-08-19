package com.thoughtworks.shokunin.fact;

import java.util.regex.Pattern;

public class IsBetterThan implements Fact {
    private static final Pattern pattern = Pattern.compile("(\\w+) is a better developer than (\\w+)");

    private final String factString;

    public IsBetterThan(String factString) {
        this.factString = factString;
    }

    public static boolean accepts(String fact) {
        return pattern.matcher(fact).matches();
    }
}
