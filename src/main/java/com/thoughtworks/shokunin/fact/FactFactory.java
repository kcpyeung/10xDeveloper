package com.thoughtworks.shokunin.fact;

import java.util.regex.Pattern;

public class FactFactory {

    private static final Pattern notTheBest = Pattern.compile("(\\w+) is not the best developer");
    private static final Pattern notTheWorst = Pattern.compile("(\\w+) is not the worst developer");
    private static final Pattern notTheBestOrWorst = Pattern.compile("(\\w+) is not the best developer or the worst developer");
    private static final Pattern isBetterThan = Pattern.compile("(\\w+) is a better developer than (\\w+)");
    private static final Pattern isNotDirectlyBelowOrAbove = Pattern.compile("(\\w+) is not directly below or above (\\w+) as a developer");

    public static Fact getFact(String factString) {
        if (notTheBest.matcher(factString).matches()) {
            return new NotTheBest(factString);
        } else if (notTheWorst.matcher(factString).matches()) {
            return new NotTheWorst(factString);
        } else if (notTheBestOrWorst.matcher(factString).matches()) {
            return new NotTheBestOrTheWorst(factString);
        } else if (isBetterThan.matcher(factString).matches()) {
            return new IsBetterThan(factString);
        } else if (isNotDirectlyBelowOrAbove.matcher(factString).matches()) {
            return new IsNotDirectlyBelowOrAbove(factString);
        } else {
            return new NullFact(factString);
        }
    }
}
