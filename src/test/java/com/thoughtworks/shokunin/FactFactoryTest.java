package com.thoughtworks.shokunin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class FactFactoryTest {

    @Test
    void notTheBest() {
        String factString = "Jessie is not the best developer";

        Fact fact = FactFactory.getFact(factString);

        assertEquals(NotTheBest.class, fact.getClass());
    }

    @Test
    void notTheWost() {
        String factString = "Evan is not the worst developer";

        Fact fact = FactFactory.getFact(factString);

        assertEquals(NotTheWorst.class, fact.getClass());
    }

    @Test
    void notTheBestOrTheWorst() {
        String factString = "John is not the best developer or the worst developer";

        Fact fact = FactFactory.getFact(factString);

        assertEquals(NotTheBestOrTheWorst.class, fact.getClass());
    }

    @Test
    void isBetterThan() {
        String factString = "Sarah is a better developer than Evan";

        Fact fact = FactFactory.getFact(factString);

        assertEquals(IsBetterThan.class, fact.getClass());
    }

    @Test
    void isNotDirectlyBelowOrAbove() {
        String factString = "Matt is not directly below or above John as a developer";

        Fact fact = FactFactory.getFact(factString);

        assertEquals(IsNotDirectlyBelowOrAbove.class, fact.getClass());
    }

    @Test
    void unknownFacts() {
        String factString = "Kevin is the best developer";

        Fact fact = FactFactory.getFact(factString);

        assertEquals(NullFact.class, fact.getClass());
    }

}
