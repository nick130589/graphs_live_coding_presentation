package com.prituladima;

import java.util.*;

public class TestsReader {

    public static void readGraph(Map<Integer, Collection<Integer>> graph, Scanner scanner) {
        // TODO: 13.10.2019 Task 1: Build graph and make tests work
    }

    public static int readFromVertex(Scanner scanner) {
        // TODO: 22.10.2019 uncomment
        //  return scanner.nextInt();
        return 0;
    }

    public static void readExpectedResult(List<Integer> ans, Scanner scanner) {
        int n = scanner.nextInt();
        while (n-- > 0) ans.add(scanner.nextInt());
    }

    public static void readRequests(List<Request> requests, Scanner scanner) {
        int n = scanner.nextInt();
        while (n-- > 0) {
            String type = scanner.next();
            if (Objects.equals(type, "AMOUNT"))
                requests.add(new Request(type));
            else
                requests.add(new Request(type, scanner.nextInt(), scanner.nextInt()));

        }
    }
}
