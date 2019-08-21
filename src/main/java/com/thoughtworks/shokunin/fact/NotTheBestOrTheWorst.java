package com.thoughtworks.shokunin.fact;

import io.vavr.collection.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NotTheBestOrTheWorst implements Fact {
    private static final Pattern pattern = Pattern.compile("(\\w+) is not the best developer or the worst developer");

    private final String factString;
    private final List<Fact> rewritten;

    public NotTheBestOrTheWorst(String factString) {
        this.factString = factString;
        rewritten = List.of(
                new NotTheBest(String.format("%s is not the best developer", getDevelopers().get(0))),
                new NotTheWorst(String.format("%s is not the worst developer", getDevelopers().get(0))));
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

    @Override
    public List<String> toProlog(Facts allFacts) {
        return rewritten.flatMap(fact -> fact.toProlog(allFacts));
    }

}
