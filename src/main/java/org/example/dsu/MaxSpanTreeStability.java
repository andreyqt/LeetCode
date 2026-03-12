package org.example.dsu;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * task: <a href="https://leetcode.com/problems/maximize-spanning-tree-stability-with-upgrades/">Maximize Spanning Tree Stability with Upgrades</a><br>
 * time complexity: {@code O(E * Log(E))}<br>
 * space complexity: {@code O(N + E)}<br>
 * difficulty: {@code hard}
 */
public class MaxSpanTreeStability {

    int components;
    int[] parent;
    int[] size;

    int findParent(int x) {
        if (parent[x] == x) return x;
        return parent[x] = findParent(parent[x]);
    }

    boolean union(int x, int y) {
        int parentX = findParent(x);
        int parentY = findParent(y);

        if (parentX == parentY) return false;
        components--;

        if (size[parentX] > size[parentY]) {
            parent[parentY] = parentX;
            size[parentX] += size[parentY];
        } else {
            parent[parentX] = parentY;
            size[parentY] += size[parentX];
        }

        return true;
    }

    public int maxStability(int n, int[][] edges, int k) {
        components = n;
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        List<int[]> must = new ArrayList<>();
        List<int[]> flex = new ArrayList<>();

        for (int[] e : edges) {
            if (e[3] == 1) must.add(e);
            else flex.add(e);
        }

        int mini = Integer.MAX_VALUE;

        for (int[] e : must) {
            int u = e[0], v = e[1], w = e[2];
            mini = Math.min(mini, w);

            if (!union(u, v)) return -1;
        }

        flex.sort((a, b) -> b[2] - a[2]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] e : flex) {
            int u = e[0], v = e[1], w = e[2];

            if (union(u, v)) pq.add(w);
        }

        while (k-- > 0 && !pq.isEmpty()) {
            int x = pq.poll();
            mini = Math.min(mini, 2 * x);
        }

        if (components != 1) return -1;
        if (!pq.isEmpty()) return Math.min(mini, pq.peek());

        return mini;
    }

}
