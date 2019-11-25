package com.prituladima;

import java.util.*;

public class BFSImpl {

    private static final int inf = (int) 1e6;

    private boolean[] used = new boolean[inf];

    public void bfs(int from, Map<Integer, Collection<Integer>> graph, List<Integer> ans) {
        // TODO: 13.10.2019 Task 2: Make tests work
        Queue<Integer> queue = new LinkedList<>();
        queue.add(from);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            if (!ans.contains(v)) {
                ans.add(v);
                Collection<Integer> edges = graph.get(v);
                for (int edge : edges) {
                    Optional<Integer> w = graph.get(v).stream().filter(e -> e.equals(edge)).findFirst();
                    w.ifPresent(queue::add);
                }
            }
        }

    }

}