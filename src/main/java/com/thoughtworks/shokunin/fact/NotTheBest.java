package com.thoughtworks.shokunin.fact;

import java.util.regex.Pattern;

public class NotTheBest implements Fact {
    private static final Pattern pattern = Pattern.compile("(\\w+) is not the best developer");

    private final String factString;

    public NotTheBest(String factString) {
        this.factString = factString;
    }

    public static boolean accepts(String fact) {
        return pattern.matcher(fact).matches();
    }
}
