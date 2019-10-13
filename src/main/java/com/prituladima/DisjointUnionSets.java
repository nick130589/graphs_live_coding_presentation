package com.prituladima;

// A Java program to implement Disjoint Set Data
// Structure.

public class DisjointUnionSets {

    private int[] rank, parent;
    private int n;

    // Constructor
    public DisjointUnionSets(int n) {
        this.rank = new int[n];
        this.parent = new int[n];
        this.n = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public boolean isInSameSet(int u, int v){
        return find(u) == find(v);
    }

    public int find(int x) {
        while (parent[x] != x) x = parent[x];
        return x;
    }

    public void union(int x, int y) {
        // Find representatives of two sets
        int xRoot = find(x), yRoot = find(y);

        // Elements are in the same set, no need
        // to unite anything.
        if (xRoot == yRoot)
            return;

        // If x's rank is less than y's rank
        if (rank[xRoot] < rank[yRoot])

            // Then move x under y so that depth
            // of tree remains less
            parent[xRoot] = yRoot;

            // Else if y's rank is less than x's rank
        else if (rank[xRoot] > rank[yRoot])

            // Then move y under x so that depth of
            // tree remains less
            parent[yRoot] = xRoot;

        else // if ranks are the same
        {
            // Then move y under x (doesn't matter
            // which one goes where)
            parent[yRoot] = xRoot;

            // And increment the the result tree's
            // rank by 1
            rank[xRoot]++;
        }
    }
}