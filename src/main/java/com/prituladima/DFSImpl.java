package com.prituladima;

import java.util.*;

public class DFSImpl {

    private static final int inf = (int)1e6;

    private boolean[] used = new boolean[inf];

    public void dfs(int from, Map<Integer, Collection<Integer>> graph, List<Integer> ans){
        // TODO: 13.10.2019 Task 3: Make tests work
        System.out.println("Visiting " + from);
        ans.add(from);
        Collection<Integer> successors = graph.get(from);
        for (int success:successors) {
            if(!ans.contains(success))
            {
                dfs(success, graph, ans);
            }
        }
    }

}