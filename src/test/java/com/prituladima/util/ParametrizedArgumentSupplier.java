package com.prituladima.util;

import org.junit.jupiter.params.provider.Arguments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static com.prituladima.TestsReader.*;

public class ParametrizedArgumentSupplier implements Supplier<Stream<Arguments>> {

    private static final String BASE = System.getProperty("user.dir");
    private static final int AMOUNT_OF_TESTS = 9;
    private static ParametrizedArgumentSupplier supplier;

    public static ParametrizedArgumentSupplier supplier() {
        if (supplier == null)
            return supplier = new ParametrizedArgumentSupplier();
        else return supplier;
    }

    private ParametrizedArgumentSupplier() {
    }

    @Override
    public Stream<Arguments> get() {
        List<Arguments> ans = new ArrayList<>();
        try (Scanner namesScanner = new Scanner(new File(BASE + "/src/test/names.txt"));
             Scanner inScanner = new Scanner(new File(BASE + "/src/test/input.txt"));
             Scanner outScanner = new Scanner(new File(BASE + "/src/test/output.dfs.txt"))) {
            for (int i = 0; i < AMOUNT_OF_TESTS; i++) {
                String name = namesScanner.nextLine();
                Map<Integer, Collection<Integer>> graph = new HashMap<>();
                readGraph(graph, inScanner);
                int from = inScanner.nextInt();
                List<Integer> expectedResult = new ArrayList<>();
                readExpectedResult(expectedResult, outScanner);
                ans.add(Arguments.of(name, graph, from, expectedResult));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return ans.stream();
    }
}
