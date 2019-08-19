package com.thoughtworks.shokunin.fact;

import java.util.regex.Pattern;

public class IsNotDirectlyBelowOrAbove implements Fact {
    private static final Pattern pattern = Pattern.compile("(\\w+) is not directly below or above (\\w+) as a developer");

    private final String factString;

    public IsNotDirectlyBelowOrAbove(String factString) {
        this.factString = factString;
    }

    public static boolean accepts(String fact) {
        return pattern.matcher(fact).matches();
    }
}
