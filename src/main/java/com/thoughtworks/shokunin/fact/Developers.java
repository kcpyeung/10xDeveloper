package com.thoughtworks.shokunin.fact;

import io.vavr.collection.List;

public class Developers {
    public final int count;

    public Developers(List<Fact> facts) {
        count = facts
                .flatMap(Fact::getDevelopers)
                .distinct()
                .length();
    }
}
