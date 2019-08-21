package com.thoughtworks.shokunin.fact;

import io.vavr.collection.List;

public class NullFact implements Fact {
    private final String factString;

    public NullFact(String factString) {
        this.factString = factString;
    }

    @Override
    public List<String> getDevelopers() {
        return List.empty();
    }

    @Override
    public List<String> toProlog(Facts allFacts) {
        throw new IllegalArgumentException("Unknown fact structure: " + factString);
    }

}
