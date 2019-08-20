package com.thoughtworks.shokunin.fact;

import io.vavr.collection.List;

import java.util.regex.Matcher;
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

    @Override
    public List<String> getDevelopers() {
        Matcher matcher = pattern.matcher(factString);
        matcher.matches();
        return List.of(matcher.group(1));
    }

}
