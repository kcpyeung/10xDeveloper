package com.thoughtworks.shokunin.fact;

import io.vavr.collection.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PrologFileGeneratorTest {

    private final List<String> factStrings = List.of(
            "Jessie is not the best developer",
            "Evan is not the worst developer",
            "John is not the best developer or the worst developer",
            "Sarah is a better developer than Evan",
            "Matt is not directly below or above John as a developer",
            "John is not directly below or above Evan as a developer");

    private final String expected =
            "devs(Devs) :-\n" +
            "  Devs = [Evan, Jessie, John, Matt, Sarah],\n" +
            "  fd_domain(Devs, 1, 5),\n" +
            "  fd_all_different(Devs),\n" +
            "  fd_labeling(Devs),\n" +
            "  Jessie =\\= 1,\n" +
            "  Evan =\\= 5,\n" +
            "  John =\\= 1,\n" +
            "  John =\\= 5,\n" +
            "  Sarah < Evan,\n" +
            "  abs(Matt - John) =\\= 1,\n" +
            "  abs(John - Evan) =\\= 1.\n";

    @Test
    void generatesCompletePrologFileFromFacts() {
        PrologFileGenerator generator = new PrologFileGenerator(factStrings);

        assertEquals(expected, generator.generate());
    }

}
