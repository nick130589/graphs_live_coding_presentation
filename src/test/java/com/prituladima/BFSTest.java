package com.prituladima;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import com.prituladima.util.VariableSource;

import java.util.*;
import java.util.stream.Stream;

import static com.prituladima.util.ParametrizedArgumentSupplier.BFS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.prituladima.util.ParametrizedArgumentSupplier.supplier;

// TODO: 10/8/2019 Parametrized tests for dfs, bfs and djus
// TODO: 10/8/2019 wrong realization for some test cases
public class BFSTest {

    public static Stream<Arguments> ARGUMENTS = supplier(BFS).get();

    @ParameterizedTest
    @VariableSource("ARGUMENTS")
    void test_bfs_order(String name, Map<Integer, Collection<Integer>> graph, int from, List<Integer> expectedAns) {

        //GIVEN
        BFSImpl bfsImpl = new BFSImpl();

        //WHEN
        List<Integer> actualAns = new ArrayList<>();
        bfsImpl.bfs(from, graph, actualAns);

        //THEN
        assertEquals(expectedAns, actualAns);

    }

}