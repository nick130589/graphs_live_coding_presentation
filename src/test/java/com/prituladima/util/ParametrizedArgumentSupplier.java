package com.prituladima.util;

import org.junit.jupiter.params.provider.Arguments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static com.prituladima.TestsReader.readExpectedResult;
import static com.prituladima.TestsReader.readGraph;

public class ParametrizedArgumentSupplier implements Supplier<Stream<Arguments>> {

    public static final String BFS = "bfs";
    public static final String DFS = "dfs";

    private static final String BASE = System.getProperty("user.dir");
    private static final int AMOUNT_OF_TESTS = 9;
    private static Map<String, ParametrizedArgumentSupplier> suppliers;

    public static ParametrizedArgumentSupplier supplier(String type) {
        suppliers = new HashMap<>();
        suppliers.computeIfAbsent(BFS, key -> new ParametrizedArgumentSupplier(type));
        suppliers.computeIfAbsent(DFS, key -> new ParametrizedArgumentSupplier(type));
        return suppliers.get(type);
    }

    private String type;

    private ParametrizedArgumentSupplier(String type) {
        this.type = type;
    }

    @Override
    public Stream<Arguments> get() {
        List<Arguments> ans = new ArrayList<>();
        try (Scanner namesScanner = new Scanner(new File(BASE + "/src/test/names.txt"));
             Scanner inScanner = new Scanner(new File(BASE + "/src/test/input.txt"));
             Scanner outScanner = new Scanner(new File(BASE + "/src/test/output." + type + ".txt"))) {
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
