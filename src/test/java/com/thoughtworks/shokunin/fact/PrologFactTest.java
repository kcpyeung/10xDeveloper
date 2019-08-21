package com.thoughtworks.shokunin.fact;

import io.vavr.collection.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class PrologFactTest {

    private final Facts allFacts = new Facts(List.of(
            "Jessie is not the best developer",
            "Evan is not the worst developer",
            "John is not the best developer or the worst developer",
            "Sarah is a better developer than Evan",
            "Matt is not directly below or above John as a developer"));

    @Test
    void notTheBest() {
        Fact fact = FactFactory.getFact("Jessie is not the best developer");

        assertEquals(List.of("Jessie =\\= 1"), fact.toProlog(allFacts));
    }

    @Test
    void notTheWost() {
        Fact fact = FactFactory.getFact("Evan is not the worst developer");

        assertEquals(List.of("Evan =\\= 5"), fact.toProlog(allFacts));
    }

    @Test
    void notTheBestOrTheWorst() {
        Fact fact = FactFactory.getFact("John is not the best developer or the worst developer");

        assertEquals(List.of("John =\\= 1", "John =\\= 5"), fact.toProlog(allFacts));
    }

    @Test
    void isBetterThan() {
        Fact fact = FactFactory.getFact("Sarah is a better developer than Evan");

        assertEquals(List.of("Sarah < Evan"), fact.toProlog(allFacts));
    }

    @Test
    void isNotDirectlyBelowOrAbove() {
        Fact fact = FactFactory.getFact("Matt is not directly below or above John as a developer");

        assertEquals(List.of("abs(Matt - John) =\\= 1"), fact.toProlog(allFacts));
    }

    @Test
    void errorFactShouldBlowUp() {
        Fact fact = new ErrorFact(Fact.class, "Kevin is the best developer", new IllegalArgumentException("Invalid and weird"));

        RuntimeException e =
                assertThrows(RuntimeException.class, () -> fact.toProlog(allFacts));

        assertEquals("Error parsing 'Kevin is the best developer'\n" +
                "Fact class: " + Fact.class.getCanonicalName() + "\n" +
                "Original exception: Invalid and weird", e.getMessage());

        assertEquals(IllegalArgumentException.class, e.getCause().getClass());
    }

    @Test
    void nullFactShouldBlowUp() {
        Fact fact = FactFactory.getFact("Kevin is the best developer");

        IllegalArgumentException e =
                assertThrows(IllegalArgumentException.class, () -> fact.toProlog(allFacts));

        assertEquals("Unknown fact structure: Kevin is the best developer", e.getMessage());
    }

}
