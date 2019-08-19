package com.thoughtworks.shokunin;

public class FactFactory {
    public static Fact getFact(String factString) {
        if (factString.endsWith("is not the best developer")) {
            return new NotTheBest(factString);
        } else if (factString.endsWith("is not the worst developer")) {
            return new NotTheWorst(factString);
        } else if (factString.endsWith("is not the best developer or the worst developer")) {
            return new NotTheBestOrTheWorst(factString);
        } else if (factString.contains("is a better developer than")) {
            return new IsBetterThan(factString);
        } else if (factString.contains("is not directly below or above")) {
            return new IsNotDirectlyBelowOrAbove(factString);
        } else {
            return new NullFact(factString);
        }
    }
}
