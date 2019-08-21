package com.thoughtworks.shokunin.fact;

import io.vavr.collection.List;

public class Facts {
    public final int developerCount;
    public final String developerNames;
    private final List<Fact> facts;

    public Facts(List<String> factStrings) {
        facts = factStrings.map(FactFactory::getFact);

        List<String> distinct = facts
                .flatMap(Fact::getDevelopers)
                .distinct();

        developerCount = distinct.length();

        developerNames = String.join(", ", distinct.sorted());
    }

}
