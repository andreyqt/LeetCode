package org.example.contest_6_2_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TaskThree {

    private static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    private static void union(int[] parent, int[] size, int x, int y) {
        x = find(parent, x);
        y = find(parent, y);

        if (x == y) {
            return;
        }

        if (size[x] < size[y]) {
            parent[x] = y;
            size[x] += size[y];
        } else {
            parent[y] = x;
            size[y] += size[x];
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> wordToContext = new HashMap<>();
        int[] parent = new int[n];
        int[] size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 0;
        }

        int contextCount = 0;

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            String[] words = br.readLine().split(" ");

            Set<String> currentWords = new HashSet<>(Arrays.asList(words));
            List<Integer> affectedContexts = new ArrayList<>();

            for (String word : currentWords) {
                if (wordToContext.containsKey(word)) {
                    int contextId = wordToContext.get(word);
                    contextCount = find(parent, contextId);
                    if (!affectedContexts.contains(contextId)) {
                        affectedContexts.add(contextId);
                    }
                }
            }

            if (affectedContexts.isEmpty()) {
                for (String word : currentWords) {
                    wordToContext.put(word, contextCount);
                }
                size[contextCount] += currentWords.size();
                contextCount++;
            } else {
                int mainContext = affectedContexts.get(0);
                mainContext = find(parent, mainContext);

                for (int j = 1; j < affectedContexts.size(); j++) {
                    int otherContext = find(parent, affectedContexts.get(j));
                    if (otherContext != mainContext) {
                        union(parent, size, mainContext, otherContext);
                    }
                }

                int root = find(parent, mainContext);
                for (String word : currentWords) {
                    if (!wordToContext.containsKey(word)) {
                        wordToContext.put(word, contextCount);
                        size[root]++;
                    }
                }
            }
        }

        Set<Integer> uniqueRoots = new HashSet<>();
        int maxSize = 0;
        for (int i = 0; i < contextCount; i++) {
            int root = find(parent, i);
            uniqueRoots.add(root);
            maxSize = Math.max(maxSize, size[root]);
        }

        System.out.println(maxSize);
    }
}
