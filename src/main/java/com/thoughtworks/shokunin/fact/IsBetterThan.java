package com.thoughtworks.shokunin.fact;

import io.vavr.collection.List;

import java.util.regex.Matcher;
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

    @Override
    public List<String> getDevelopers() {
        Matcher matcher = pattern.matcher(factString);
        matcher.matches();
        return List.of(matcher.group(1), matcher.group(2));
    }

    @Override
    public List<String> toProlog(Facts allFacts) {
        return List.of(String.format("%s < %s", getDevelopers().get(0), getDevelopers().get(1)));
    }

}
