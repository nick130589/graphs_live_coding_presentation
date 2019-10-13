package com.prituladima;

import java.util.*;

public class TestsReader {

    public static void readGraph(Map<Integer, Collection<Integer>> graph, Scanner scanner) {
        // TODO: 13.10.2019 Task 3: Build graph and make tests work
    }

    public static int readFrom(Scanner scanner){
//        return scanner.nextInt();
        return 0;
    }

    public static void readExpectedResult(List<Integer> ans, Scanner scanner) {
        int n = scanner.nextInt();
        while (n-- > 0) ans.add(scanner.nextInt());
    }
}
