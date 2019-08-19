package com.thoughtworks.shokunin.fact;

import java.util.regex.Pattern;

public class NotTheBestOrTheWorst implements Fact {
    private static final Pattern pattern = Pattern.compile("(\\w+) is not the best developer or the worst developer");

    private final String factString;

    public NotTheBestOrTheWorst(String factString) {
        this.factString = factString;
    }

    public static boolean accepts(String fact) {
        return pattern.matcher(fact).matches();
    }
}
