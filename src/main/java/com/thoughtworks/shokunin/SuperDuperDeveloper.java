package com.thoughtworks.shokunin;

import com.thoughtworks.shokunin.fact.PrologFileGenerator;
import io.vavr.collection.List;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SuperDuperDeveloper {

    public static void main(String[] args) throws IOException {
        String file = args.length == 1 ? args[0] : "input.txt";
        List<String> factStrings = readFacts(file);

        try (BufferedWriter out = new BufferedWriter(new FileWriter("10x_dev.pl"))) {
            out.write(new PrologFileGenerator(factStrings).generate());
        }
    }

    private static List<String> readFacts(String arg) throws IOException {
        return List.ofAll(Files.readAllLines(Paths.get(arg)));
    }

}
