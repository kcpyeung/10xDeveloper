package com.thoughtworks.shokunin.fact;

import io.vavr.collection.List;

public class PrologFileGenerator {

    private final List<Fact> facts;
    private final Facts allFacts;

    public PrologFileGenerator(List<String> factStrings) {
        facts = factStrings.map(FactFactory::getFact);
        allFacts = new Facts(factStrings);
    }

    public String generate() {
        return head() + " :-\n" +
                body();
    }

    private String head() {
        return "devs(Devs)";
    }

    private String body() {
        return unification() + conjunction() +
                domain() + conjunction() +
                different() + conjunction() +
                labelling() + conjunction() +
                developerGoals() +
                end();
    }

    private String developerGoals() {
        return String.join(conjunction(),
                facts
                    .flatMap(f -> f.toProlog(allFacts))
                    .map(s -> String.format("  %s", s)));
    }

    private String labelling() {
        return "  fd_labeling(Devs)";
    }

    private String different() {
        return "  fd_all_different(Devs)";
    }

    private String domain() {
        return String.format("  fd_domain(Devs, 1, %d)", allFacts.developerCount);
    }

    private String unification() {
        return String.format("  Devs = [%s]", allFacts.developerNames);
    }

    private String conjunction() {
        return ",\n";
    }

    private String end() {
        return ".\n";
    }

}
