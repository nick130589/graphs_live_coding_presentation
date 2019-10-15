package com.prituladima;

import com.prituladima.util.VariableSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;


import static com.prituladima.util.DJUSParametrizedArgumentSupplier.supplier;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DJUSTest {

    public static Stream<Arguments> ARGUMENTS = supplier().get();

    @ParameterizedTest
    @VariableSource("ARGUMENTS")
    public void test_disjoint_union_sets(int amountOfVertexes, List<Request> requests, List<Integer> expectedResults) {
        DisjointUnionSets djus = new DisjointUnionSets(amountOfVertexes);

        int counter = 0;
        for (int i = 0; i < requests.size(); i++) {
            Request request = requests.get(i);
            if (request.getType() == 'A') {
                int expected = expectedResults.get(counter++);
                int actual = djus.getAmount();
                assertEquals(expected, actual);
                System.out.printf("Amount of connected component expected: %d; actual: %d\n", expected, actual);

            } else if (request.getType() == 'C') {
                int from = request.getFrom();
                int to = request.getTo();
                djus.union(from, to);
                System.out.printf("Union of: %d <> %d\n", from, to);

            } else if (request.getType() == 'R') {
                int from = request.getFrom();
                int to = request.getTo();

                boolean expectedInTheSameSet = expectedResults.get(counter++) == 1;
                boolean actualInTheSameSet = djus.isInSameSet(from, to);
                assertEquals(expectedInTheSameSet, actualInTheSameSet);

                System.out.printf("Vertexes are expected to be in the same union: %d <> %d\n", from, to);


            } else throw new IllegalStateException();
        }

    }

}
