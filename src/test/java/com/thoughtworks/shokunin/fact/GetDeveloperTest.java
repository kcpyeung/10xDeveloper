package com.thoughtworks.shokunin.fact;

import io.vavr.collection.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


class GetDeveloperTest {

    @Test
    void notTheBest() {
        String factString = "Jessie is not the best developer";

        Fact fact = FactFactory.getFact(factString);

        assertEquals(List.of("Jessie"), fact.getDevelopers());
    }

    @Test
    void notTheWost() {
        String factString = "Evan is not the worst developer";

        Fact fact = FactFactory.getFact(factString);

        assertEquals(List.of("Evan"), fact.getDevelopers());
    }

    @Test
    void notTheBestOrTheWorst() {
        String factString = "John is not the best developer or the worst developer";

        Fact fact = FactFactory.getFact(factString);

        assertEquals(List.of("John"), fact.getDevelopers());
    }

    @Test
    void isBetterThan() {
        String factString = "Sarah is a better developer than Evan";

        Fact fact = FactFactory.getFact(factString);

        assertEquals(List.of("Sarah", "Evan"), fact.getDevelopers());
    }

    @Test
    void isNotDirectlyBelowOrAbove() {
        String factString = "Matt is not directly below or above John as a developer";

        Fact fact = FactFactory.getFact(factString);

        assertEquals(List.of("Matt", "John"), fact.getDevelopers());
    }

}
